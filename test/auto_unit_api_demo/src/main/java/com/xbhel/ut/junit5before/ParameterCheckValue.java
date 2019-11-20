package com.xbhel.ut.junit5before;

/**
 * @Author: xbhel
 * @Date: 2019/11/16 13:24
 * @Description: 参数化测试
 */
public class ParameterCheckValue {

    /**
     * 业务方法 验证是否是素数
     * @param param
     * @return
     */
    public Boolean validate(int param){
        for(int i=2;i<(param>>1);i++){
            if(param%i==0){
                return false;
            }
        }
        return true;
    }
}
