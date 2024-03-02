package com.ms.user.services;

import com.ms.user.dtos.PostDTO;
import com.ms.user.dtos.UserDTO;
import com.ms.user.entities.User;
import com.ms.user.producers.PostProducer;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostProducer postProducer;


    public User postUser(UserDTO userDTO){
        if (userRepository.findByUsername(userDTO.username()) != null){
            return null;
        }
        var user = new User(userDTO);
        return userRepository.save(user);
    }


    public PostDTO publishPost(PostDTO data, String username) throws Exception {
        if (userRepository.findByUsername(username) != null){
            postProducer.publishPost(data, username);
            return data;
        }
        throw new Exception("usuario não existe");
    }
}
