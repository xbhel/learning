package com.xbhel.ut.mock.quickstart.api;

import com.xbhel.ut.common.Course;
import com.xbhel.ut.common.Student;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * @Author: xbhel
 * @Date: 2019/11/20 21:36
 * @Description: How to use <code>@InjectMock</code>
 */
public class InjectMocksTest {
    @Mock
    private Course course;
    @InjectMocks
    private Student student;

    @Before
    public void setUp(){
        //初始化TestClass中所有标记了@Mock @Spy @InjectMock @Captor的属性
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_how_to_use_injectMock(){


        System.out.println(student.getClass());
        //        when(student.getCourse().info()).thenReturn("InjectMock 帮我找到依赖关系了~~~");
//        assertThat(student.getCourse().info(),equalTo("InjectMock 帮我找到依赖关系了~~~"));
    }
}
