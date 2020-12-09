import fizzbuzz.AbstractFizzBuzz;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class KafkaConsumerExample {
    private final static String TOPIC_NAME = "fizzbuzz";

    public static void main(String[] args) {
        Consumer<String, String> consumer = KafkaConsumerExample.createConsumer();
        consumer.subscribe(Collections.singletonList(TOPIC_NAME));
        try {
            String receivedText = null;
            while (!"exit".equalsIgnoreCase(receivedText)) {
                //kafka queued messages
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    receivedText = record.value();
                    int n = Integer.parseInt(receivedText);
                    if (receivedText != null) {
                        List<AbstractFizzBuzz> sortedImpl = getImplementations();
                        for (AbstractFizzBuzz impl: sortedImpl){
                            if(impl.match(n)){
                                System.out.println(impl.message());
                                break;
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
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

    private static List<AbstractFizzBuzz> getImplementations() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // reflection, getting all the implementations of fizzbuzz cases
        Reflections reflections = new Reflections("fizzbuzz");
        Set<Class<? extends AbstractFizzBuzz>> classes = reflections.getSubTypesOf(AbstractFizzBuzz.class);

        List<AbstractFizzBuzz> list = new ArrayList<>();

        for (Class<? extends AbstractFizzBuzz> i:classes)
            list.add(i.getDeclaredConstructor().newInstance());

        //sorting them
        return list.stream().sorted().collect(toList());
    }
}