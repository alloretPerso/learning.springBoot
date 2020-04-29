package com.learning.spring.boot.fundamentals.repository;

import com.learning.spring.boot.fundamentals.entity.Release;
import org.springframework.data.repository.CrudRepository;

public interface ReleaseRepository extends CrudRepository<Release,Long> {
}
