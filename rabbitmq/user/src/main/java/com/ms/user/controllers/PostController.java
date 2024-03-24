package com.ms.user.controllers;

import com.ms.user.dtos.PostDTO;
import com.ms.user.entities.User;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posting")
public class PostController extends AbstractController{

    @Autowired
    private UserService userService;

    @PostMapping("{username}")
    public void newPost(@RequestBody PostDTO data, @PathVariable("username") String username){
        ResponseEntity.status(HttpStatus.OK).body(userService.publishPost(data, username));
    }
}
