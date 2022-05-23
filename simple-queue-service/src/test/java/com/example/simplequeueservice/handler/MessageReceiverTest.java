package com.example.simplequeueservice.handler;

import com.example.simplequeueservice.dto.MessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MessageReceiverTest {
    @Autowired
    private MessageSender messageSender;

    @Autowired
    private MessageReceiver messageReceiver;

    @Test
    void receiveMessage() throws JsonProcessingException {
        //given
        MessageDto messageDto = new MessageDto("Hello World");
        this.messageSender.send(messageDto);

        //when
        MessageDto receivedMessageDto = messageReceiver.receive();

        //then
        Assertions.assertEquals("Hello World", receivedMessageDto.getStr());
    }
}