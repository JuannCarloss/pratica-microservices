package com.ms.posts.services;

import com.ms.posts.documents.PostDocument;
import com.ms.posts.dtos.PostDTO;
import com.ms.posts.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    public PostDocument newPost(PostDTO data){
        var save = new PostDocument(data);
        return postsRepository.save(save);
    }
}
