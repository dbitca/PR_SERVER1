package com.example.Producer.application;

import com.example.Producer.models.Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    @PostMapping("/object")
    public ResponseEntity orderReady(@RequestBody Object object){
        Logger logger = LoggerFactory.getLogger(ProducerController.class);
        logger.info("Order " + object.getId() + " has been received from aggregator server.");
        return new ResponseEntity(HttpStatus.OK);
    }

}


