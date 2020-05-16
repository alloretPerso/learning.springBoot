package com.learning.spring.boot.fundamentals.service;


import com.learning.spring.boot.fundamentals.entity.Application;
import com.learning.spring.boot.fundamentals.errors.ApplicationNotFoundException;

public interface ApplicationService {
    Iterable<Application> listApplications();

    Application findApplication(long id) throws ApplicationNotFoundException;
}


