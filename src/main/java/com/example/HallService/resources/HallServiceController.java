package com.example.HallService.resources;

import com.example.HallService.models.Order;
import com.example.HallService.models.OrderGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hall")
public class HallServiceController {

    @PostMapping("/order")
    public ResponseEntity orderReady(@RequestBody Order order){
        Logger logger = LoggerFactory.getLogger(HallServiceController.class);
        logger.info("Order " + order.getId() + " has been received from server3.");
        return new ResponseEntity(HttpStatus.OK);
    }

}


