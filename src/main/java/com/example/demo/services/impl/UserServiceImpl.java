package com.example.demo.services.impl;

import com.example.demo.domain.AppUser;
import com.example.demo.domain.dto.UserDTO;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.services.exceptions.DataIntegratyViolationException;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public AppUser findById(Integer id) {
        Optional<AppUser> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<AppUser> findAll(){
        return repository.findAll();
    }

    @Override
    public AppUser create(UserDTO obj) {
        findByEamil(obj);
        return repository.save(mapper.map(obj, AppUser.class));
    }

    @Override
    public AppUser update(UserDTO obj){
        findByEamil(obj);
        return repository.save(mapper.map(obj, AppUser.class));
    }

    private void findByEamil(UserDTO obj){
    Optional<AppUser> user = repository.findByEmail(obj.getEmail());
    if(user.isPresent() && !user.get().equals(obj.getId())){
        throw new DataIntegratyViolationException("Em@il já cadastrado no sistema!");
    }
    }
}
