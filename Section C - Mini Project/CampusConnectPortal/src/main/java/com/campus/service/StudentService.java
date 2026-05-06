package com.campus.service;

import com.campus.model.Student;

public interface StudentService {

    void registerStudent(Student student);

    Student loginStudent(String email, String password);
}