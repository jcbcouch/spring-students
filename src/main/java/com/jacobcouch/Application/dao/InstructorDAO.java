package com.jacobcouch.Application.dao;

import com.jacobcouch.Application.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDAO extends JpaRepository<Instructor, Integer> {
    Instructor findById(int theId);
}
