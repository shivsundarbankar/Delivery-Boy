package com.shivsundar.delivery.boy.services;

import com.shivsundar.delivery.boy.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class kafkaServiceImpl implements KafkaService {

    @Autowired
    private KafkaTemplate<String ,String> kafkaTemplate;
    public boolean updateLocation(String location){
        kafkaTemplate.send(Constants.LOCATION_UPDATE,location);
        return true;
    }
}
