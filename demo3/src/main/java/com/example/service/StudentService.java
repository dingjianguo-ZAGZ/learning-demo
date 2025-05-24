package com.example.service;

import com.example.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private Student student;
    public Student getStudent(){
        return student;
    }
}
