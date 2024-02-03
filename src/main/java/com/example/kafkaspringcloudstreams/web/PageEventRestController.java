package com.example.kafkaspringcloudstreams.web;

import com.example.kafkaspringcloudstreams.entities.PageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class PageEventRestController {
    /*
    1- Publier les évenements, kafka<--RestController, en utilisant Spring cloud streams function
    */
    @Autowired
    private StreamBridge streamBridge;
    @GetMapping("/publish/{topic}/{name}")
    public PageEvent publish(@PathVariable String topic, @PathVariable String name){
        PageEvent pageEvent=new PageEvent(name,Math.random()>0.5?"U1":"U2",new Date(),new Random().nextInt(900));
        streamBridge.send(topic,pageEvent);
        return pageEvent;
    }
}
