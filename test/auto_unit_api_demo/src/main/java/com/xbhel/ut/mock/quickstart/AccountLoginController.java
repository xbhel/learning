package com.xbhel.ut.mock.quickstart;

import com.xbhel.ut.common.Account;
import com.xbhel.ut.common.AccountDao;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xbhel
 * @Date: 2019/11/17 20:37
 * @Description:
 */
public class AccountLoginController {
    /**
     *accountDao 假设AccountDao是注入的，通过构造模拟注入
     */
    private final AccountDao accountDao;

    public AccountLoginController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 模拟登录
     * @param request
     * @return
     */
    public  String login(HttpServletRequest request){
        final String userName=request.getParameter("username");
        final String password=request.getParameter("password");
        try {
            Account account = accountDao.findAccount(userName, password);
            if(account==null){
                return "/login";
            }else {
                return "/index";
            }
        } catch (Exception e) {
            //数据库不可用的处理方法
            return "/505";
        }

    }

}
