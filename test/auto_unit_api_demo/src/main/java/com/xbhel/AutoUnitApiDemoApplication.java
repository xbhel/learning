package com.xbhel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Auto test demo class
 *
 * @author xbhel
 * @date 2019/11/16
 */
@SpringBootApplication
public class AutoUnitApiDemoApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AutoUnitApiDemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AutoUnitApiDemoApplication.class);
    }
}
