package com.jacobcouch.Application.dao;

import com.jacobcouch.Application.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository<Course, Integer> {
}
