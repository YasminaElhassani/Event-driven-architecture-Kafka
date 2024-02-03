package com.example.kafkaspringcloudstreams.service;

import com.example.kafkaspringcloudstreams.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class PageEventService {

    /*
     2- On va consommer des évenements en utilisant Spring cloud streams function
     */
    @Bean
    public Consumer<PageEvent> pageEventConsumer() {
        /*
         Il reçoit un message en input à partir de Topic Kafka
         */
        return (input) -> {
            System.out.println("Voici le message");
            System.out.println(input.toString());
            System.out.println("***************");
        };
    }
}



