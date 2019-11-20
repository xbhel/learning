package com.xbhel.ut.common;

import lombok.Data;

/**
 * @Author: xbhel
 * @Date: 2019/11/16 18:18
 * @Description:
 */
@Data
public class Student {
    private String id;
    private String sname;
    private Course course;

    public void learning(String courseId) {
    }
    public Course getCourse() {
        throw new RuntimeException();
    }
}
