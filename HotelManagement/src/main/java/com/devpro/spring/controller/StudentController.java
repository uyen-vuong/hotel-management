package com.devpro.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.devpro.spring.model.Student;
import com.devpro.spring.service.StudentService;


@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@RequestMapping("/infor")
	public String studentInfor(Model model) {
		List<Student> listStudents = service.getList();
		model.addAttribute("listStudents", listStudents);
		return "studentInfor";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/student/infor";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable(name = "id") long id) {
		ModelAndView view = new ModelAndView("editStudent");
		Student student = service.getStudent(id);
		view.addObject("student", student);
		return view;
	}

	@RequestMapping("/new")
	public String addNewStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "newStudent";
	}

	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name = "id") int id) {
		service.deleteStudent(id);
		return "redirect:/student/infor";
	}
}
