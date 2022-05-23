package com.example.simplequeueservice.handler;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.example.simplequeueservice.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageReceiver {
    @Value("${cloud.aws.sqs.queue.name}")
    private String QUEUE_NAME;

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public MessageReceiver(AmazonSQSAsync amazonSQSAsync) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQSAsync);
    }

    public MessageDto receive() {
        MessageDto messageDto = queueMessagingTemplate.receiveAndConvert(QUEUE_NAME, MessageDto.class);

        return messageDto;
    }
}
