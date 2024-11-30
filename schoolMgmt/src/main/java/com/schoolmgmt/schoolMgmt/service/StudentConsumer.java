package com.schoolmgmt.schoolMgmt.service;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.stereotype.Service;

@Service
public class StudentConsumer {
    @KafkaHandler
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
