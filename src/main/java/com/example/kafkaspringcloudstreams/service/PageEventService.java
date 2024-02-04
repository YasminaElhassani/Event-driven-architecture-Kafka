package com.example.kafkaspringcloudstreams.service;

import com.example.kafkaspringcloudstreams.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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

    @Bean
    public Supplier<PageEvent> pageEventSupplier(){
        return ()-> new PageEvent(
                Math.random()>0.5?"P1":"P2",
                Math.random()>0.5?"yasmina":"elhassani",
                new Date(),
                new Random().nextInt(900)
        );
        }

    @Bean
    public Function<PageEvent,PageEvent> pageEventFunction(){
        return (input)->{
            input.setName("L:"+input.getName().length());
            input.setUser("User function");
            return input;
        };
    }
}




