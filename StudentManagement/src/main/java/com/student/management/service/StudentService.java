package com.student.management.service;

import java.util.List;
import java.util.Optional;

import com.student.management.entity.Student;

public interface StudentService {
	List<Student>getAllStudent();
	Optional<Student>findById(int id);
	Optional<Student>findByemail( String email);
	Student save(Student id);
	void deletedById(int id);
	

}
