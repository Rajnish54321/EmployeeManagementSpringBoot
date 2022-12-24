package com.student.management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.Exception.StudentNotFoundException;
import com.student.management.entity.Student;
import com.student.management.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping(value = "/students")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@GetMapping(value = "/students/{id}")
	public Student getStudentById(@PathVariable("id") int id) {
		Student stu = studentService.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student with " + id + "is notfound"));
		return stu;
	}

	@PostMapping(value = "/students")
	public Student addStudent(@RequestBody Student std) {
		return studentService.save(std);
	}

	@PutMapping(value = "/students/{id}")
	public Student updateStudent(@PathVariable("id") int id, @RequestBody Student newstd) {
		Student stdu = studentService.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
		stdu.setFirstname(newstd.getFirstname());
		stdu.setLastname(newstd.getLastname());
		stdu.setEmail(newstd.getEmail());
		return studentService.save(stdu);
	}

	@DeleteMapping(value = "/students/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		Student std = studentService.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
		studentService.deletedById(std.getId());
		return "Student with ID :" + id + " is deleted";
	}
}
