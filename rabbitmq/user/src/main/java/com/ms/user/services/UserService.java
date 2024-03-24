package com.ms.user.services;

import com.ms.user.dtos.PostDTO;
import com.ms.user.entities.User;
import com.ms.user.producers.EmailProducer;
import com.ms.user.producers.PostProducer;
import com.ms.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostProducer postProducer;

    @Autowired
    private EmailProducer emailProducer;


    @Transactional
    public User postUser(User user){
        if (userRepository.findByUsername(user.getUsername()) != null){
            return null;
        }
        var save = userRepository.save(user);
        emailProducer.sendEmail(user);
        return save;
    }


    @Cacheable(value = "users")
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
