package com.home;

import com.home.pojo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/4/21 19:04
 **/
@Configuration
public class MyConfig {

    @Bean
    public Student configStudent() {
        Student student = new Student(11, "Configuration配置的张三", 11, "测试注解版spring启动流程");
        return student;
    }

}
