package com.kafka.strproducer.config;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Configuration
public class KafkaAdminConfig {

    public final KafkaProperties properties;

    @Bean
    public KafkaAdmin kafkaAdmin(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers() );
        return new KafkaAdmin(configs);
    }

    @Bean
    public KafkaAdmin.NewTopics topics () {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("str-topic")
                        .partitions(2)
                        .replicas(1)
                        .build()
        );
    }
}
