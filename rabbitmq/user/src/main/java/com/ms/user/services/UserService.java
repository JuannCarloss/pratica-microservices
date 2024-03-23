package com.ms.user.services;

import com.ms.user.dtos.PostDTO;
import com.ms.user.dtos.RegisterDTO;
import com.ms.user.dtos.UserDTO;
import com.ms.user.entities.User;
import com.ms.user.producers.PostProducer;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostProducer postProducer;


    public User postUser(User user){
        if (userRepository.findByUsername(user.getUsername()) != null){
            return null;
        }
        return userRepository.save(user);
    }

    public Page<User> getAll(String filter, Pageable pageable){
        return userRepository.findAll(filter, User.class, pageable);
    }


    public PostDTO publishPost(PostDTO data, String username) throws Exception {
        if (userRepository.findByUsername(username) != null){
            postProducer.publishPost(data, username);
            return data;
        }
        throw new Exception("usuario não existe");
    }
}
