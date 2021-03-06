package com.example.simplequeueservice.handler;

import com.amazonaws.services.sqs.model.SendMessageResult;
import com.example.simplequeueservice.dto.MessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageSenderTest {
    @Autowired
    private MessageSender messageSender;

    @Test
    void send() throws JsonProcessingException {
        //given
        MessageDto messageDto = new MessageDto("Hello World");

        //when
        SendMessageResult sendMessageResult = this.messageSender.send(messageDto);

        //then
        Assertions.assertNotNull(sendMessageResult.getMessageId());
    }
}