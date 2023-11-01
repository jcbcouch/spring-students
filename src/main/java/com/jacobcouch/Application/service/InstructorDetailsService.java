package com.jacobcouch.Application.service;

import com.jacobcouch.Application.entity.InstructorDetail;

import java.util.List;
import java.util.Optional;

public interface InstructorDetailsService {
    List<InstructorDetail> findAll();

    Optional<InstructorDetail> findById(int theId);

    InstructorDetail save(InstructorDetail theInstructor);

    void deleteById(int theId);
}
