package com.xbhel;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

/**
 * @author xbhel
 * @date 2019/11/16
 * webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
 * 测试时随机分配一个端口，解决端口冲突问题
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AutoUnitApiDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    @Timeout(3)
    public void test(){
        List mock = mock(List.class);
        when(mock.isEmpty()).thenReturn(false);
        assertFalse(mock.isEmpty());
    }

}
