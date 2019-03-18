package chj.java;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

public class KafkaSimpleConsumer {

    private static void consumer() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = KafkaSimpleConsumer.class.getClassLoader().getResourceAsStream("chj/config/consumer.properties");
        properties.load(inputStream);
        Consumer<String,String> consumer = new KafkaConsumer<String, String>(properties);
        Collection<String> topics = Arrays.asList("aa");
        consumer.subscribe(topics);
        ConsumerRecords<String,String> consumerRecords = null;
        while (true){
            try {
                Duration duration = Duration.ZERO;
//                duration.
                consumerRecords = consumer.poll(duration);
                //消费kafka
                for (ConsumerRecord consumerRecord:consumerRecords){
                    long offset = consumerRecord.offset();//偏移量
                    long partition = consumerRecord.partition();//分区
                    Object key = consumerRecord.key(); //键
                    Object value = consumerRecord.value();//值
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        Duration duration = Duration.ZERO;
        System.out.println(duration.toDays());
    }
}
