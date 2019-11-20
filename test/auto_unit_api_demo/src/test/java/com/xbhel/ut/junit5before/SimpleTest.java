package com.xbhel.ut.junit5before;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.*;

/**
 * @Author: xbhel
 * @Date: 2019/11/16 14:23
 * @Description:
 */
public class SimpleTest {

    @Test
    public  void get_result_when_vals_is_empty(){
        //模拟返回结果
        int result=0;
        //classic风格：即验证某项条件为真，在这个方法中需要验证执行方法的结果
        assertTrue(result==0);
        //matcher风格，通过语义化的代码来验证结果是否匹配
       assertThat(result,equalTo(0));
    }
}
