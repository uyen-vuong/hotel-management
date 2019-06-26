package com.devpro.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpro.spring.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
