package com.xbhel.ut.mock.api;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;


/**
 * @Author: xbhel
 * @Date: 2019/11/20 22:25
 * @Description:
 */
public class ArticleManagerTest extends BasicTest{

    //@Mock private ArticleCalculator articleCalculator;
    //@Mock(name = "database")  指定名称
    @Mock(name = "database") private ArticleDatabase articleDatabase;
    @InjectMocks private ArticleManager manager;

    @Test
    public  void test_how_to_use_injectMock(){
        // System.out.println(manager.getCalculator().getClass());
        System.out.println(manager.getDatabase().getClass());
    }

}
