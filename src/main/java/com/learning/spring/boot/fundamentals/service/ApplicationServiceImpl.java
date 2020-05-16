package com.learning.spring.boot.fundamentals.service;


import com.learning.spring.boot.fundamentals.entity.Application;
import com.learning.spring.boot.fundamentals.repository.ApplicationRepository;
import com.learning.spring.boot.fundamentals.errors.ApplicationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Iterable<Application> listApplications() {
        return applicationRepository.findAll();
    }


    @Override
    public Application findApplication(long id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);

        if(optionalApplication.isPresent())
            return optionalApplication.get();
        else
            throw new ApplicationNotFoundException("Application Not Found", (long) 13);
    }


}
