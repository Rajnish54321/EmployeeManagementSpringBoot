package com.student.management.reposiotery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
Optional<Student >findByEmail(String email);
}
