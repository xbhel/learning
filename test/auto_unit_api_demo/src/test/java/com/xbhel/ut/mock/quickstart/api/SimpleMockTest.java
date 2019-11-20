package com.xbhel.ut.mock.quickstart.api;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @Author: xbhel
 * @Date: 2019/11/16 17:34
 * @Description:
 */
//@RunWith(MockitoJUnitRunner.class)
public class SimpleMockTest {

    @Mock
    private  List<String> list;

//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Ignore
    public void mockTest(){
        //mock List实例
        List listMock = mock(List.class);
        //mock实例行为
        when(listMock.isEmpty()).thenReturn(false);
        //断言
        assertFalse(listMock.isEmpty());
        //验证行为是否被mock实例调用
        verify(listMock).isEmpty();
    }

    @Test
    public void annotation_mock_test(){
        when(list.isEmpty()).thenReturn(false);
        assertFalse(list.isEmpty());
        verify(list).isEmpty();
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


}
