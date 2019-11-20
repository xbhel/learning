package com.xbhel.ut.mock.quickstart;

import com.xbhel.ut.common.Account;
import com.xbhel.ut.common.AccountDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

/**
 * @Author: xbhel
 * @Date: 2019/11/17 20:46
 * @Description: Mockito mock AccountLoginController login
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {

    private AccountDao accountDao;
    private HttpServletRequest request;
    private AccountLoginController accountLoginController;

    @Before
    public void setUp() {
        this.accountDao = mock(AccountDao.class);
        this.request = mock(HttpServletRequest.class);
        this.accountLoginController=new AccountLoginController(accountDao);
    }

    /**
     * 模拟成功登录
     */
    @Test
    public void testLoginSuccess(){
        Account account = new Account();
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findAccount(anyString(),anyString())).thenReturn(account);
        assertThat(accountLoginController.login(request),equalTo("/index"));
    }

    /**
     * 模拟登录失败
     */
    @Test
    public void testLoginFailure(){
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("1234561");
        when(accountDao.findAccount(anyString(),anyString())).thenReturn(null);
        assertThat(accountLoginController.login(request),equalTo("/login"));
    }

    /**
     * 模拟数据库崩溃
     * 假设开始没有考虑数据库崩溃，通过测试发现从而完善也是TDD
     */
    @Test
    public void testLogin505(){
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("1234561");
        when(accountDao.findAccount(anyString(),anyString())).thenThrow(UnsupportedOperationException.class);
        assertThat(accountLoginController.login(request),equalTo("/505"));
    }

}
