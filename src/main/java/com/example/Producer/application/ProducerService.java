package com.example.Producer.application;
import com.example.Producer.threads.WorkingThreads;
public class ProducerService {
    public static void InitializeWorkingThreads() {
        try {
            for (int i = 0; i < 6; i++) {
                new WorkingThreads("Working thread " + String.valueOf(i));
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void InitializeBlockingThreads(){

    }
}
