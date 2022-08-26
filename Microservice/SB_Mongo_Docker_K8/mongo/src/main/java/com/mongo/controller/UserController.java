package com.mongo.controller;

import com.mongo.model.User;
import com.mongo.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
public class UserController {

    @Autowired
    UserRepo repo;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser(){
        log.info("Inside getAllUsers");
        return repo.findAll();
    }

    @GetMapping("test")
    @ResponseStatus(HttpStatus.OK)
    public String getTest(){
        log.info("Inside getTest");
        return "Hello Test....";
    }
}
