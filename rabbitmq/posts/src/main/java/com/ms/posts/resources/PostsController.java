package com.ms.posts.resources;

import com.ms.posts.documents.PostDocument;
import com.ms.posts.dtos.PostDTO;
import com.ms.posts.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    @Autowired
    private PostsService service;

    @PostMapping
    public ResponseEntity post(@RequestBody PostDTO data){
        var save = service.newPost(data);
        return ResponseEntity.ok().body(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") String id, @RequestBody PostDocument post){
        var save = service.updatePost(id, post);
        return ResponseEntity.ok().body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "3") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<PostDocument> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);

    }

    @GetMapping("/list")
    public ResponseEntity listAll(){
        List<PostDTO> list = service.listAll();
        return ResponseEntity.ok(list);
    }
}
