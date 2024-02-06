package com.example.demo.services.impl;

import com.example.demo.domain.AppUser;
import com.example.demo.domain.dto.UserDTO;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class UserServiceImplTest {

    int ID = 6;
    String nome = "Vitoria";
    String email = "vitoria@email.com";
    String password = "753";
    @InjectMocks
    private UserServiceImpl service;
    @Mock
    private UserRepository repository;
    @Mock
    private ModelMapper mapper;
    private AppUser user;
    private UserDTO userDTO;
    private Optional<AppUser> optionalAppUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdReturnAnUserInstance() {
        when(repository.findById(Mockito.anyInt())).thenReturn(optionalAppUser);

        AppUser response = service.findById(ID);

        assertNotNull(response);
        assertEquals(AppUser.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(nome, response.getNome());
        assertEquals(email, response.getEmail());
    }

    @Test
    void whenFindByIdaThenReturnAnObjectNotFoundException(){
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));

        try {
            service.findById(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto não encontrado", ex.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnALinstOfUsers() {
        when(repository.findAll()).thenReturn(List.of(user));

        List<AppUser> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(AppUser.class, response.get(0).getClass());

        assertEquals(ID, response.get(0).getId());
        assertEquals(nome, response.get(0).getNome());
        assertEquals(email, response.get(0).getEmail());
        assertEquals(password, response.get(0).getPassword());
    }

    @Test
    void whenCreateThenReturnSuccess() {
        when(repository.save(any())).thenReturn(user);

        AppUser response = service.create(userDTO);

        assertNotNull(response);
        assertEquals(AppUser.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(nome, response.getNome());
        assertEquals(email, response.getEmail());
        assertEquals(password, response.getPassword());
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
        optionalAppUser = Optional.of(new AppUser(ID, nome, email, password));
    }
}