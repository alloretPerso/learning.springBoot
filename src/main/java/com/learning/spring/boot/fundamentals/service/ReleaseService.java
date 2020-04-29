package com.learning.spring.boot.fundamentals.service;


import com.learning.spring.boot.fundamentals.entity.Release;

public interface ReleaseService {
    Iterable<Release> listReleases();
}


