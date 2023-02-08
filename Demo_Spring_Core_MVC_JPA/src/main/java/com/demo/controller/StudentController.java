package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.Student;
import com.demo.dao.StudentDao;

@RestController
public class StudentController {

	@Autowired
	private StudentDao dao;

	@PostMapping("/student")
	public void insertStudent(@RequestBody Student student) {
		this.dao.insertStudent(student);
	}

	@GetMapping("/students")
	public void getStudents() {
		this.dao.getStudents();
	}
}
