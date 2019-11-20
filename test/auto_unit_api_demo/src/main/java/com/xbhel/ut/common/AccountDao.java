package com.xbhel.ut.common;

/**
 * @Author: xbhel
 * @Date: 2019/11/17 20:38
 * @Description:
 */
public class AccountDao {

    /**
     * 模拟数据库 ，假设数据库崩溃了，抛出异常
     * @param username
     * @param password
     * @return
     */
    public Account findAccount(String username, String password) {
        throw new UnsupportedOperationException();
    }
}
