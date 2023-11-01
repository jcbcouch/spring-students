package com.jacobcouch.Application.service;


import com.jacobcouch.Application.dao.InstructorDetailDAO;
import com.jacobcouch.Application.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailsService{
    private InstructorDetailDAO instructorDetailDAO;

    @Autowired
    public InstructorDetailServiceImpl(InstructorDetailDAO theInstructorDetailDAO) {
        instructorDetailDAO = theInstructorDetailDAO;
    }

    @Override
    public List<InstructorDetail> findAll() {
        return instructorDetailDAO.findAll();
    }

    @Override
    public Optional<InstructorDetail> findById(int theId) {
        return instructorDetailDAO.findById(theId);
    }


    @Override
    public InstructorDetail save(InstructorDetail theInstructorDetail) {
        return instructorDetailDAO.save(theInstructorDetail);
    }

    @Override
    public void deleteById(int theId) {
        instructorDetailDAO.deleteById(theId);
    }
}
