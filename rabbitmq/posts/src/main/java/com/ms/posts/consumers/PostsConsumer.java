package com.ms.posts.consumers;

import com.ms.posts.dtos.PostDTO;
import com.ms.posts.services.PostsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PostsConsumer {

    @Autowired
    private PostsService postsService;

    @RabbitListener(queues = "${broker.queue.posts.name}")
    public void listenPost(@Payload PostDTO data){
        var post = postsService.newPost(data);
    }
}
