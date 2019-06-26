package com.devpro.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devpro.spring.model.Student;
import com.devpro.spring.repository.StudentRepository;



@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getList(){
		return studentRepository.findAll();
	}
	
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	
	public Student getStudent(long id) {
		return studentRepository.findById(id).get();
	}
	
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}
}
