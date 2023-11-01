package com.jacobcouch.Application.dao;

import com.jacobcouch.Application.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailDAO extends JpaRepository<InstructorDetail, Integer> {
}
