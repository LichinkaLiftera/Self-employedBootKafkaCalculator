package com.example.consumer;

import com.example.consumer.functions.Calculator;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.LinkedList;
import java.util.List;


@SpringBootApplication
@EnableKafka
public class ConsumerApplication {
    private static List<String> messages = new LinkedList<>();

    @KafkaListener(topics = "message")
    public void messageListener(ConsumerRecord<Integer, String> consumerRecord) {
        messages.add(consumerRecord.value());
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ConsumerApplication.class, args);
        Calculator calculator = new Calculator();
        Thread.sleep(5000);
        while (true) {
            if (!messages.isEmpty()) {
                System.out.println(calculator.calculate(messages.get(0)));
                messages.remove(0);
                Thread.sleep(1000);
            } else {
                System.out.println("Wait...");
                Thread.sleep(3000);
            }
        }
    }
}
