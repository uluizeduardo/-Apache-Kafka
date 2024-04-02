package com.kafka.strproducer.services;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@AllArgsConstructor
@Service
public class StringProducerService {

    public final KafkaTemplate<String, String> kafkaTemplate;

    public void enviarMensagem(String mensagem){
        kafkaTemplate.send("str-topic", mensagem).addCallback(
                success -> {
                    if(success != null) {
                        log.info("Mensagem enviado com sucesso {}", mensagem);
                        log.info("Partition {}, Offset {}",
                                success.getRecordMetadata().partition(),
                                success.getRecordMetadata().offset());
                    }
                },
                error -> log.error("Erro ao tentar enviar a mensagem")
        );
    }
}
