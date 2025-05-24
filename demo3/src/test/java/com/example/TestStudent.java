package com.example;

import com.example.controller.StudentController;
import com.example.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestStudent {
    @Autowired
    private StudentController studentController;
    @Test
    public void getStudent(){
        Student student = studentController.getStudent();
        System.out.println(student);
    }
}
