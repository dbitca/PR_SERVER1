package com.example.HallService.models;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class OrderGenerator {
    static HttpHeaders headers = new HttpHeaders();
    static RestTemplate restTemplate = new RestTemplate();
    public static int OrderId = 1;

    public OrderGenerator(){}

    public static Order GenerateOrder(){
        var orderId = OrderId++;
        var order = new Order(orderId);
        //System.out.println("Generated order " + order.getId());
        return order;
    }

    public static void sendOrders (Order order) {
        // set the media type of http header request
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Order> entity = new HttpEntity<>(order, headers);
        // send current order to kitchen
        restTemplate.postForEntity("http://localhost:8083/server3/orderHall", entity, Order.class);
    }
}
