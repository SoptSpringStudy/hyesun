package com.spring;

import com.spring.dao.StudentDao;
import com.spring.services.StudentRegisterService;
import com.spring.services.StudentSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(StudentConfig2.class)
public class StudentConfig {

    @Autowired
    StudentDao studentDao;

    @Bean
    public StudentRegisterService studentRegisterService(){
        return new StudentRegisterService(studentDao);
    }

    @Bean
    public StudentSearchService studentSearchService(){
        return new StudentSearchService(studentDao);
    }
}