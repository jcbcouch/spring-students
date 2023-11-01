package com.jacobcouch.Application.dao;

import com.jacobcouch.Application.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Integer> {
}
