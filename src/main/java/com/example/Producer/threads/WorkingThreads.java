package com.example.Producer.threads;
import com.example.Producer.models.Object;
import com.example.Producer.models.ObjectProducer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class WorkingThreads implements Runnable{

    Thread t;
    String threadname;
    int id;
    static ObjectProducer objectProducer = new ObjectProducer();
    static HttpHeaders headers = new HttpHeaders();
    static RestTemplate restTemplate = new RestTemplate();

    public WorkingThreads(String thread){
        threadname = thread;
        t = new Thread (this, threadname);
        System.out.println("New thread :" + t);
        t.start();
    }
    @Override
    public void run() {
        while(true){
            try
            {
                var object = ObjectProducer.GenerateObject();
                sendObjects(object);
                Thread.sleep(3000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void sendObjects(Object object) {
        // set the media type of http header request
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Object> entity = new HttpEntity<>(object, headers);
        // send current order to agregator
        restTemplate.postForEntity("http://localhost:8083/agregator/objectProducer", entity, Object.class);
    }
}
