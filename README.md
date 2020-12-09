# fizzbuzz
FizzBuzz algorithm

Two projects: Producer and Consumer. The first one for sending numbers across a kafka server, the second one to receive those numbers and get an output in streaming.

For usage:
  Install Kafka 2.3.0
  Run Zookeeper and Kafka server in bootsrap mode (localhost:9092)
  Create a topic "fizzbuzz"
  Run the Producer project, need kafka-clients-2.3.0.
  Run the Consumer project (KafkaConsumer), need: reflection-0.9.10, kafka-clients-2.3.0 and junit-4.13 for testing purposes.
