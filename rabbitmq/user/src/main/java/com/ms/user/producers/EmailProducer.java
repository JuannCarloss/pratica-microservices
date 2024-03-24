package com.ms.user.producers;

import com.ms.user.dtos.EmailDTO;
import com.ms.user.entities.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.emails.name}")
    private String routingkey;

    public void sendEmail(User data){
        var email = new EmailDTO();

        email.setUserId(data.getId());
        email.setEmailTo(data.getEmail());
        email.setSubject("Cadastro realizado com sucesso!");
        email.setBody(data.getUsername() + " Obrigado por ter se cadastrado na nossa plataforma!!!");

        rabbitTemplate.convertAndSend("", routingkey, email);
    }
}
