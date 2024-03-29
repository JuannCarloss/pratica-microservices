package com.ms.user.controllers;

import com.ms.user.dtos.UserDTO;
import com.ms.user.entities.User;
import com.ms.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity getAll(@RequestParam(required = false) String filter,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "3") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<UserDTO> users = userService.getAll(filter, pageable)
                .map(user -> new UserDTO(
                        user.getUsername(),
                        user.getEmail()
                ));
        return ResponseEntity.ok().body(users);
    }
}
