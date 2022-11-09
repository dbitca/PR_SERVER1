package com.example.Producer.threads;

import java.util.concurrent.Semaphore;

public class BlockingThreads implements Runnable{
    Thread t;
    Semaphore semaphore = WorkingThreads.semaphore;
    String threadname;

    public BlockingThreads(String thread){
        threadname = thread;
        t = new Thread(this, threadname);
        System.out.println("New thread blocking thread:" + t);
        t.start();
    }
    @Override
    public void run() {
        try{
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
