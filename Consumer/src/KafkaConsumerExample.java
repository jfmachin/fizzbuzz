import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerExample {
    private final static String TOPIC_NAME = "fizzbuzz";

    public static void main(String[] args) {
        Consumer<String, String> consumer = KafkaConsumerExample.createConsumer();
        consumer.subscribe(Collections.singletonList(TOPIC_NAME));
        try {
            String receivedText = null;
            while (!"exit".equalsIgnoreCase(receivedText)) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

                for (ConsumerRecord<String, String> record : records) {
                    receivedText = record.value();
                    if (receivedText != null) {
                        IFizzBuzz.class
                        System.out.println(receivedText);
                    }
                }
            }
        } finally {
            consumer.close();
        }
    }

    private static Consumer<String, String> createConsumer() {
        Properties kafkaProps = new Properties();
        kafkaProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        kafkaProps.put(ConsumerConfig.GROUP_ID_CONFIG, "test_consumer_group");
        kafkaProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        kafkaProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        return new KafkaConsumer<String, String>(kafkaProps);
    }
}