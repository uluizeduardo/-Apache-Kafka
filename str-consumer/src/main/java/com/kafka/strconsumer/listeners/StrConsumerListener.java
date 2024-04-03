package com.kafka.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                    @TopicPartition(topic = "str-topic", partitions = {"0"})
            },
            containerFactory = "strContainerFactory")
    public void create(String mensagem){
        log.info("CREATE ::: Recebeu a mensagem {}", mensagem);
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                @TopicPartition(topic = "str-topic", partitions = {"1"})
            },
            containerFactory = "strContainerFactory")
    public void log(String mensagem){
        log.info("LOG ::: Recebeu a mensagem {}", mensagem);
    }


    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
    public void history(String mensagem){
        log.info("HISTORY ::: Recebeu a mensagem {}", mensagem);
    }
}
