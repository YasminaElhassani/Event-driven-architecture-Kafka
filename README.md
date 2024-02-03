# Event-Driven Architecture Project Readme
## Introduction

Welcome to our event-driven architecture project! This project is designed to demonstrate the power and flexibility of event-driven systems using Kafka and Spring Cloud Streams. Before diving into the details, let's understand the basic setup and requirements.
Event Driven Architerchture:

![software architecture_event_driven](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/d7c63ebf-38af-4fc0-aa59-0273daa87d8d)

## Setup Instructions
To get started, follow these steps:

Start Zookeeper:
start bin\windows\zookeeper-server-start.bat config/zookeeper.properties
Start Kafka
start bin\windows\kafka-server.start.bat config/server.properties
Run the Components:
Run the producer and consumer: 
start bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic R1
start bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic R1

## 1. Producer-Consumer Test
This project includes a test suite for validating the communication between a producer and a consumer. It ensures that messages are produced and consumed successfully within the system.
![success test](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/f223817f-2880-42f3-b1a3-9a70aacced89)


2. Controller & Consumer
We have implemented a controller responsible for publishing messages using Spring Cloud Streams. On the other end, a consumer is designed to consume these messages efficiently.
![publier des evenements](https://github.com/YasminaElhassani/Event-driven-architecture-Kafka/assets/103280152/e77e15a0-540f-4ea6-9085-4bbf8231c3d5)

4. Producer Poller
The producer poller is a crucial component designed to poll for data and publish it to Kafka topics at specified intervals. This feature enables continuous data ingestion and processing within the system.

5. Kafka Streams
Kafka Streams is a powerful library for building applications and microservices where the input and output data are stored in Kafka clusters. In our project, Kafka Streams are utilized for various stream processing tasks.

Contribution Guidelines
We welcome contributions to this project! If you have any ideas, improvements, or bug fixes, feel free to open an issue or submit a pull request.

Support
If you encounter any issues or have questions about the project, please don't hesitate to reach out to us via GitHub issues.

License
This project is licensed under the MIT License.

Thank you for using our event-driven architecture project! We hope it helps you understand and implement robust event-driven systems using Kafka and Spring Cloud Streams. Happy coding!
