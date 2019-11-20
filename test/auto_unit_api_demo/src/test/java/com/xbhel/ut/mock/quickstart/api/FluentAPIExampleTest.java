package com.xbhel.ut.mock.quickstart.api;


import com.xbhel.ut.common.Student;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @Author: xbhel
 * @Date: 2019/11/16 18:17
 * @Description:
 */
public class FluentAPIExampleTest {

    @Test
    public void test() {
        Student student = mock(Student.class);
        when(student.getId()).thenReturn("20191116");
        assertEquals("20191116",student.getId());
    }

    // 返回多个值
    @Test
    public void test_more_than_one_return_val(){
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("first").thenReturn("second");
        assertEquals("first",iterator.next());
        assertEquals("second",iterator.next());
    }


    // 如何根据输入来返回值
    @Test
    public void testReturnValueDependentOnMethodParameter()  {
        Comparable c= mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Intellij")).thenReturn(2);
        assertEquals(1,c.compareTo("Mockito"));
    }

    // 如何让返回值不依赖于输入
    @Test
    public void test_return_value_in_dependent_on_method_parameter()  {
        Comparable c= mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        assertEquals(-1 ,c.compareTo(9));
    }

    // 根据参数类型来返回值
    @Test
    public void testReturnValueInDependentOnMethodParameter()  {
        Comparable c= mock(Comparable.class,RETURNS_SMART_NULLS);
        when(c.compareTo(isA(Student.class))).thenReturn(0);
//        assertEquals(0 ,c.compareTo(new Student()));
    }

    /**
     * doReturn(...).when(...).methodCall
     */
    @Test(expected = IOException.class)
    public void   test_for_ioException() throws IOException {
        OutputStream outputStream=mock(OutputStream.class);
        doThrow(new IOException()).when(outputStream).close();
        OutputStreamWriter streamWriter= new OutputStreamWriter(outputStream);
        streamWriter.close();
    }

    /**
     * verify()
     */
    @Test
    public void verify_mock_method_and_special_param(){
        Student student = mock(Student.class);
        when(student.getId()).thenReturn("2019");
        student.getId();
        student.getId();
        student.learning("1314");
        // verify(student,times(2)).getId();
        //验证方法是否被调用两次
        verify(student,times(2)).getId();
        // 查看在传入参数为1314的时候方法是否被调用
        verify(student).learning(ArgumentMatchers.eq("1314"));

        // 其他用来验证函数是否被调用的方法
        //验证方法是否调用了从没有调用
        verify(student, never()).learning("never called");
        //验证方法是否调用了至少一次
        verify(student, atLeastOnce()).learning("called at least once");
        //验证方法是否调用了至少几次
        verify(student, atLeast(2)).learning("called at least twice");
        //验证方法是否调用了5次
        verify(student, times(5)).learning("called five times");
        //验证方法是否调用了最多几次
        verify(student, atMost(3)).learning("called at most 3 times");
    }

    @Test
    public void spy_test(){
        LinkedList<String> linkedList = new LinkedList<>();
        LinkedList<String> spy = spy(linkedList);
        //optionally, you can stub out some methods （打桩）
        when(spy.size()).thenReturn(100);
        //spy对象会调用真实对象的add()
        spy.add("first");
        spy.add("second");
        //打印 "one",集合的第一个元素
        System.out.println(spy.get(0));
        //打印"100",size()方法已经打了桩
        System.out.println(spy.size());
        verify(spy).add("first");
        verify(spy).add("second");
    }

    @Test
    public void spy_test_two(){
        LinkedList<String> linkedList = new LinkedList<>();
        LinkedList<String> spy = spy(linkedList);
        //会调用真实对象的get(0)方法，linkedList 为空， throws IndexOutOfBoundsException
        when(spy.get(0)).thenReturn("foo");

        //可以采用doReturn() 进行Stub(打桩)
        doReturn("foo").when(spy).get(0);
    }


    @Test
    public void test_any_reset(){
        List mock = mock(List.class);
        when(mock.get(0)).thenReturn(11);
        assertThat(mock.get(0),equalTo(11));
        reset(mock);//销毁 stubbing
        when(mock.get(anyInt())).thenAnswer(invocation->{
            Integer index = invocation.getArgument(0, Integer.class);
            return  index*10;
        });
        assertThat(mock.get(0),equalTo(0));
        assertThat(mock.get(1),equalTo(10));
    }


}
