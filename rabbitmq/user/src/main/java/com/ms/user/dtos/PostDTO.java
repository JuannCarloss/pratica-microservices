package com.ms.user.dtos;


import com.ms.user.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO{

    private String username;
    private String title;
    private String body;

}
