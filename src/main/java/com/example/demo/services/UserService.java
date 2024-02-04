package com.example.demo.services;

import com.example.demo.domain.AppUser;
import com.example.demo.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    AppUser findById(Integer id);
    List<AppUser> findAll();
    AppUser create(UserDTO obj);
}
