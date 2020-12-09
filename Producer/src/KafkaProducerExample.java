import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Scanner;

class KafkaProducerExample {
    public final static String TOPIC_NAME = "fizzbuzz";

    public static void main(String[] args) {
        Producer<String, String> producer = KafkaProducerExample.createProducer();
        Scanner sc = new Scanner(System.in);
        try {
            String input = null;
            while (!"exit".equalsIgnoreCase(input)) {
                input = sc.nextLine();
                ProducerRecord<String, String> recordToSend = new ProducerRecord<>(TOPIC_NAME, input);
                producer.send(recordToSend, (recordMetadata, error) -> {
                    if (error == null) System.out.println("Message successfully sent");
                    else System.out.println("Error while sending message. ");
                });
            }
        } finally {
            sc.close();
            producer.flush();
            producer.close();
        }
    }

    private static Producer<String, String> createProducer() {
        Properties kafkaProps = new Properties();
        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<String, String>(kafkaProps);
    }
}