package ru.itis.api.pdf;

import lombok.RequiredArgsConstructor;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.dto.UserDto;

@RestController
@RequiredArgsConstructor
public class PDFController {

    @PostMapping("/pdf/generate")
    public ResponseEntity<?> generatePDF(@RequestBody UserDto userDto) {
        String name = userDto.getFirstName();
        System.out.println(name);
        String surName = userDto.getLastName();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicPublish("", "queue_1", null, name.getBytes());
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return ResponseEntity.ok().build();
    }



}
