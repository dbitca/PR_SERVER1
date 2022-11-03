package com.example.HallService;

import com.example.HallService.resources.HallServiceWaiters;

public class HallService {

    public static void InitializeWaiters() {
        try {
            for (int i = 0; i < 6; i++) {
                new HallServiceWaiters("Waiter " + String.valueOf(i));
                //Thread.sleep(500);
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
