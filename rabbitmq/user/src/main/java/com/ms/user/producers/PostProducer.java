package com.ms.user.producers;

import com.ms.user.dtos.PostDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PostProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Value("${broker.queue.posts.name}")
    private String routingkey;

    public void publishPost(PostDTO data, String username){
        data.setUsername(username);
        rabbitTemplate.convertAndSend("", routingkey, data);
    }
}
