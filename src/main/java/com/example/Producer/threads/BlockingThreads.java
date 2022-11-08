package com.example.Producer.threads;

public class BlockingThreads implements Runnable{
    Thread t;

    public BlockingThreads(){
        t = new Thread();
        t.start();
    }
    @Override
    public void run() {

    }
}
