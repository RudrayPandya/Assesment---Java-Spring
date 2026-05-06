package com.campus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.campus.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmailAndPassword(String email, String password);
}