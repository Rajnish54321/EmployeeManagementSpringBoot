package com.student.management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.entity.Student;
import com.student.management.reposiotery.StudentRepository;
import com.student.management.service.StudentService;
@Service
public class StudentImpl implements StudentService {

	@Autowired
	StudentRepository studentrepo;
	
	public StudentImpl(StudentRepository studentrepo) {
		super();
		this.studentrepo = studentrepo;
	}

	@Override
	public List<Student> getAllStudent() {
		
		
		return studentrepo.findAll();
	}

	@Override
	public Optional<Student> findById(int id) {
		
		return studentrepo.findById(id);
	}

	@Override
	public Optional<Student> findByemail(String email) {
		
		return studentrepo.findByEmail(email);
	}

	@Override
	public Student save(Student id) {
	
		return studentrepo.save(id);
	}

	@Override
	public void deletedById(int id) {
		studentrepo.deleteById(id);
		
	}

}
