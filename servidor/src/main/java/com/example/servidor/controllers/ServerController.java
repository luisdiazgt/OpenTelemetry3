package com.example.servidor.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;

@RestController
@RequestMapping("/servidor")
public class ServerController {

    @Autowired
    ObservationRegistry observationRegistry;

    @Autowired
    RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(ServerController.class);

    @GetMapping("/holaMundo")
    public String getTraceCliente(){
        
        log.info("Petición en servidor");

        return Observation
                .createNotStarted("tuconnector.rise", observationRegistry) // metrica a guardar
                .contextualName("span name") // span name
                .lowCardinalityKeyValue("parametros a guardar", "test") // parametros se pueden agregar al trace
                .lowCardinalityKeyValue("parametros a guardar2", "test2") // parametros pueden ser varios
                .highCardinalityKeyValue("parametro para span", "testParametroPadre") // parametro solamente se puede agregar al span
                .observe(() -> {

                    HttpHeaders headers = new HttpHeaders();
                    Map<String, String> params = new HashMap<>();
                    HttpEntity<?> request = new HttpEntity<>("", headers);

                    log.info("Antes de consumir cliente");

                    ResponseEntity<String> response=restTemplate.exchange("http://localhost:8081/cliente/holaMundo", HttpMethod.GET, request, String.class, params);

                    log.info("Después de consumir cliente");

                    return response.getBody();

                    
                } );


    }
}
