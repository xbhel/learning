package com.xbhel.ut.mock.quickstart.api;

import com.xbhel.ut.common.Course;
import com.xbhel.ut.common.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.apache.logging.log4j.ThreadContext.isEmpty;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * @Author: xbhel
 * @Date: 2019/11/19 21:20
 * @Description: Answers.RETURNS_DEEP_STUBS
 */
@RunWith(MockitoJUnitRunner.class)
public class DeepMockTest {
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private Student student;
    @Mock
    private Course course;

    @Test
    public void testMockFail() {
        Course course = student.getCourse();
        //NullPointerException
        course.info();
    }

    @Test
    public void testMockSolve() {
        when(student.getCourse()).thenReturn(course);
        Course course = student.getCourse();
        course.info();
    }

    @Test
    public void testDeepMockSuccess() {
        //当mock当前对象时,顺便将返回值也给我mock了,使用于不进行stubbing的时候，
        // 否则会抛出 org.mockito.exceptions.misusing.UnfinishedStubbingException
        student.getCourse().info();
    }

}
