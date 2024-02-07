package com.example.kafkaspringcloudstreams.service;

import com.example.kafkaspringcloudstreams.entities.PageEvent;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Duration;
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

    /*@Bean
    public Function<KStream<String,PageEvent>,KStream<String,Long>> kStreamFunction(){
        return (input)->{
            return input
                    .filter((k,v)->v.getDuration()>100)
                    .map((k,v)->new KeyValue<>(v.getName(),0L))
                    .groupBy((k,v)->k, Grouped.with(Serdes.String(),Serdes.Long()))
                    .windowedBy(TimeWindows.of(Duration.ofSeconds(1)))
                    .count(Materialized.as("page-count"))
                    .toStream()
                    .map((k,v)->new KeyValue<>("=>"+k.window().startTime()+k.window().endTime()+k.key(),v));
        };
    }*/
    @Bean
    public  Function<KStream<String,PageEvent>,KStream<String,Long>> kStreamKStreamFunction() {
        return (input) -> {
            return input
                    .filter((k, v) -> v.getDuration() > 100)
                    .map((k, v) -> new KeyValue<>(v.getName(), 0L))
                    .groupBy((k, v) -> k, Grouped.with(Serdes.String(), Serdes.Long()))

                    /*
                       windowed By here we calculate just the evolution in period of time !
                     */
                    .windowedBy(TimeWindows.of(Duration.ofSeconds(5)))
                    /*
                        create a store called page-count
                     */
                    .count(Materialized.as("page-count"))
                    .toStream()
                    .map((k, v) -> new KeyValue<>(k.key(), v));

        };
    }
}




