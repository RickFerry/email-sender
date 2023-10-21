package com.ms.user.producer;

import com.ms.user.model.User;
import com.ms.user.model.dto.EmailDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final RabbitTemplate template;
    @Value("${broker.queue.email.name}")
    private String routingKey;

    public UserProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void publishMessageEmail(User user) {
        template.convertAndSend("", routingKey, new EmailDto(user));
    }
}