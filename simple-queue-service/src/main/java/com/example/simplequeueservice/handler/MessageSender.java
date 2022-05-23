package com.example.simplequeueservice.handler;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.example.simplequeueservice.dto.SendMessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageSender {
    @Value("${cloud.aws.sqs.queue.url}")
    private String QUEUE_NAME;

    private ObjectMapper objectMapper = new ObjectMapper();

    private final AmazonSQSAsync amazonSQSAsync;

    public SendMessageResult send(final SendMessageDto sendMessageDto) throws JsonProcessingException {

        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withMessageGroupId("1")
                .withQueueUrl(QUEUE_NAME)
                .withMessageBody(objectMapper.writeValueAsString(sendMessageDto));

        SendMessageResult sendMessageResult = amazonSQSAsync.sendMessage(sendMessageRequest);

        return sendMessageResult;
    }
}
