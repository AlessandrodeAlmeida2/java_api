package com.example.demo.services;

import com.example.demo.domain.AppUser;

public interface UserService {
    public AppUser findById(Integer id);
}
