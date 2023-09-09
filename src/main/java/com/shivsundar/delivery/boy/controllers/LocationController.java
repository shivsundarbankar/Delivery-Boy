package com.shivsundar.delivery.boy.controllers;

import com.shivsundar.delivery.boy.services.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private KafkaService kafkaService;
    private Logger logger = LoggerFactory.getLogger(LocationController.class);

    @PostMapping("/update")
    public ResponseEntity<?> update(){

        for(int i=0;i<200000;i++){
            kafkaService.updateLocation(LocalDateTime.now().toString());
            logger.info("Updated {}  ",LocalDateTime.now().toString());
        }
        return new ResponseEntity<>(Map.of("location", "updated!!"), HttpStatus.OK);
    }
}
