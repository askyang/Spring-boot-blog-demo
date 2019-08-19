package cn.ufan0.blog_test.toDoUtil;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

class time {

    @Test
    void test1() {
        // 方法一 速度最快
        System.out.println(System.currentTimeMillis());
        // 方法二
        System.out.println(Calendar.getInstance().getTimeInMillis());
        // 方法三
        System.out.println(new Date().getTime());
        // SQL最佳方案
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }
}
