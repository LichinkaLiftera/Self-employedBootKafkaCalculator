package com.example.producer;

import com.example.producer.configure.ProducerConfiguration;
import com.example.producer.controllers.MessageController;
import com.example.producer.numGenerator.Generator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ProducerApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ProducerApplication.class, args);
        MessageController messageController = new MessageController(new ProducerConfiguration().kafkaTemplate());
        Generator generator = new Generator();

        for (int i = 1; i > 0; i++) {
            messageController.sendMessage(i, generator.generateExpression());
            Thread.sleep(1000);
            System.out.println("Send -> " + i);
        }
    }
}
