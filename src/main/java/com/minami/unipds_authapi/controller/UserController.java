package com.minami.unipds_authapi.controller;

import com.minami.unipds_authapi.model.User;
import com.minami.unipds_authapi.security.MyToken;
import com.minami.unipds_authapi.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private IUserService service;

    public UserController(IUserService service) {
        super();
        this.service = service;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.status(201).body(service.addUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<MyToken> login(@RequestBody User user) {
        return ResponseEntity.ok().body(service.login(user));
    }
}
