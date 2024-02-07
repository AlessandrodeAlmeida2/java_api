package com.example.demo.resources;

import com.example.demo.domain.AppUser;
import com.example.demo.domain.dto.UserDTO;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserResourceTest {

    int ID = 6;
    String nome = "Vitoria";
    String email = "vitoria@email.com";
    String password = "753";

    private AppUser user;
    private UserDTO userDTO

    @InjectMocks
    private UserResource resource;

    @Mock
    private UserService service;

    @Mock
    private ModelMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){

        user = new AppUser(ID, nome, email, password);
        userDTO = new UserDTO(ID, nome, email, password);
    }
}