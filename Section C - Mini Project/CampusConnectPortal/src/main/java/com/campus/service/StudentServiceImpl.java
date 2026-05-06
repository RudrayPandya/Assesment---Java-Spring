package com.campus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.model.Student;
import com.campus.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void registerStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student loginStudent(String email, String password) {
        return studentRepository.findByEmailAndPassword(email, password);
    }
}