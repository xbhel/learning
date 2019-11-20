package com.xbhel.ut.mock.api;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * @Author: xbhel
 * @Date: 2019/11/20 22:24
 * @Description: BasicMock TestClass
 */
public class BasicTest {
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
}
