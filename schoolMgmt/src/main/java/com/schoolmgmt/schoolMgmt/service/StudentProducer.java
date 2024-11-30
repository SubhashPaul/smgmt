package com.schoolmgmt.schoolMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentProducer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendStudentMessage(String message) {
        kafkaTemplate.send("students-topic", message);
    }
}
