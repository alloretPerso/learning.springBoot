package com.learning.spring.boot.fundamentals.service;


import com.learning.spring.boot.fundamentals.entity.Application;

public interface ApplicationService {
    Iterable<Application> listApplications();
}


