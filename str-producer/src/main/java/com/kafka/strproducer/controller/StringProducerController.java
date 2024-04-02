package com.kafka.strproducer.controller;

import com.kafka.strproducer.services.StringProducerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/producer")
public class StringProducerController {

    public final StringProducerService service;

    @PostMapping
    public ResponseEntity<?> enviarMensagem(@RequestBody String mensagem){
        service.enviarMensagem(mensagem);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
