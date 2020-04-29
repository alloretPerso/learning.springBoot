package com.learning.spring.boot.fundamentals.repository;

import com.learning.spring.boot.fundamentals.entity.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application,Long> {
}
