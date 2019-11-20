package com.xbhel.ut.junit5before;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Author: xbhel
 * @Date: 2019/11/16 13:28
 * @Description: JUnit 5 之前版本
 */
/**
 * 第一步 ：用@RunWith(Parameterized.class)来标记Test类
 */

@RunWith(Parameterized.class)
public class ParameterCheckValueTest {
    private  ParameterCheckValue parameterCheckValue;
    /**
     *第二步 ：声明测试类变量，分别存储所用数据和期望值
     */
    private int number;
    private boolean expectedResult;

    @Before
    public void setUp(){
        this.parameterCheckValue=new ParameterCheckValue();
    }

    /**
     * 第三步：创建一个公共的构造函数，它接受和一行和第二步相同的数据，为实例变量赋值
     * @param number
     * @param expectedResult
     */
    public ParameterCheckValueTest(int number,boolean expectedResult){
        this.number=number;
        this.expectedResult=expectedResult;
    }

    /**
     * 第四步：创建一个由@Parameter标记的public static method，它返回一个对象的集合(数组)来作为测试数据集合.
     * @return
     */
    @Parameterized.Parameters
    public static Collection paramPata(){
        return Arrays.asList(new Object[][]{
                {2,true},
                {9,false},
                {19,true},
                {21,false},
                {30,false}
        });
    }

    /**
     * 编写测试方法，用实例变量作为测试数据的来源进行测试
     */
    @Test
    public void test_validate(){
        Assert.assertEquals(expectedResult,parameterCheckValue.validate(number));
    }

}
