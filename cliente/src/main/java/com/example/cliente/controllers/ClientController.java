package com.example.cliente.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/holaMundo")
    public String getTraceSimple2() throws InterruptedException{
        
        log.info("Inicio de petición en cliente");

        // 3 seguntos
        Thread.sleep(3000);

        return "Respuesta de cliente";

    }
    
}
