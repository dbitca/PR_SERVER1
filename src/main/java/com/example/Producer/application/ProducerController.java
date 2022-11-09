package com.example.Producer.application;

import com.example.Producer.models.Object;
import com.example.Producer.threads.WorkingThreads;
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
    Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @PostMapping("/object")
    public ResponseEntity objectReceived(@RequestBody Object object) {
        logger.info("Object " + object.getId() + " has been received from aggregator server.");
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/signal")
    public ResponseEntity signalReceived(@RequestBody boolean signal) {
        logger.info("Signal received");
        WorkingThreads.Signal(signal);
        return new ResponseEntity(HttpStatus.OK);
    }
}


