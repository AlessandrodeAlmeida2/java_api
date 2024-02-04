package com.example.demo.services;

import com.example.demo.domain.AppUser;

import java.util.List;

public interface UserService {
    AppUser findById(Integer id);
    List<AppUser> findAll();
}
