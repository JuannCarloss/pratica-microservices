package com.ms.posts.services;

import com.ms.posts.documents.PostDocument;
import com.ms.posts.dtos.PostDTO;
import com.ms.posts.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    public PostDocument newPost(PostDTO data){
        var save = new PostDocument(data);
        return postsRepository.save(save);
    }

    public PostDocument updatePost(String id, PostDocument updated){
        Optional<PostDocument> optional = postsRepository.findById(id);
        if (optional.isPresent()){
            var post = optional.get();
            post.setTitle(updated.getTitle());
            post.setBody(updated.getBody());
            return postsRepository.save(post);
        }
        return null;
    }

    public Page<PostDocument> findAll(Pageable pageable){
        return postsRepository.findAll(pageable);
    }

    @Cacheable("posts")
    public List<PostDTO> listAll(){
        return postsRepository.findAll().stream().map(post -> new PostDTO(
                post.getUsername(),
                post.getTitle(),
                post.getBody()
        )).collect(Collectors.toList());
    }
}
