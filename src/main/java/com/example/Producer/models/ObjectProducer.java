package com.example.Producer.models;

public class ObjectProducer {
    public static int ObjectId = 1;

    public ObjectProducer(){}

    public static Object GenerateObject(){
        var orderId = ObjectId++;
        var object = new Object(ObjectId);
        return object;
    }
}
