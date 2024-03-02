package com.ms.user.controllers;

import com.ms.user.dtos.UserDTO;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity postUser(@RequestBody @Valid UserDTO userDTO){
        var save = userService.postUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
}
