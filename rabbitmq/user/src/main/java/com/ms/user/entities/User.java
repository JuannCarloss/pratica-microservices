package com.ms.user.entities;

import com.ms.user.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "email", nullable = false)
    private String email;

    public User (UserDTO data){
        this.username = data.username();
        this.email = data.email();
    }

}