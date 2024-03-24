package com.ms.email.consumers;

import com.ms.email.entities.Email;
import com.ms.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService service;

    @RabbitListener(queues = "${broker.queue.emails.name}" )
    public void listenEmailQueue(@Payload Email email) {
        service.sendEmail(email);
    }
}
