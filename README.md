# Event-Driven Architecture Project Readme
## Introduction

Welcome to our event-driven architecture project! This project is designed to demonstrate the power and flexibility of event-driven systems using Kafka and Spring Cloud Streams. Before diving into the details, let's understand the basic setup and requirements.

## Event Driven Architerchture:

![software architecture_event_driven](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/d7c63ebf-38af-4fc0-aa59-0273daa87d8d)

## Kafka Architecture:

![architechture kafka](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/a046d00e-8bb3-4060-a023-fa467a80ed8b)

## Setup Instructions
To get started, follow these steps:

### Start Zookeeper:

start bin\windows\zookeeper-server-start.bat config/zookeeper.properties

### Start Kafka

start bin\windows\kafka-server.start.bat config/server.properties

### Run the producer and consumer: 

start bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic R1

start bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic R1

![start zookeeper_kafka_consumer_producer](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/482cd887-ce2d-4c73-abde-57af2756a384)

## 1. Producer-Consumer Test

This project includes a test suite for validating the communication between a producer and a consumer. It ensures that messages are produced and consumed successfully within the system.

![success test](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/f223817f-2880-42f3-b1a3-9a70aacced89)


## 2. ControllerEventProducer & Consumer
   
We have implemented a controller responsible for publishing messages using Spring Cloud Stream Function. On the other end, a consumer is designed to consume these messages efficiently.

![publier des evenements](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/e77e15a0-540f-4ea6-9085-4bbf8231c3d5)

## Consumer

The messages are consumed successfully:

![2-consumer](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/584fd1cf-d4a7-48d3-9ac6-9aa8abfde85d)

## 3- Supplier/Producer Poller
 
The producer poller is a crucial component designed to poll for data and publish it to Kafka topics. 

By default, Spring Cloud Stream configures the supplier to push a message every second. You can configure the timing using the following property: 

#### spring.cloud.stream.poller.fixed-delay=100.


![supplier](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/42edfa0f-0a29-4c1a-b0ae-4b17ebd81b74)

## 4- Producer & Consumer

### Producer
The producer is responsible for publishing messages to the specified destination (Kafka topic). It generates and sends data to the messaging system for consumption by a consumer.

### Consumer
The consumer is tasked with receiving and processing messages from the messaging system. It subscribes to the specified destination (Kafka topic).

![producer_consumer](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/06ec2b86-33ab-4ba3-9fea-43854e2d6355)

## 5-Kafka Streams

With kafka streams

![a](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/4307ed57-5ed4-4e96-8918-13006e526e04)


![b](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/9a61a00e-f2cc-4ca6-a9d8-bb1ec6a986c5)







