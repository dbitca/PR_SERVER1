package com.example.HallService.resources;

import com.example.HallService.models.OrderGenerator;

public class HallServiceWaiters implements Runnable{

    Thread t;
    String waitername;
    int id;
    static OrderGenerator orderGenerator = new OrderGenerator();

    public HallServiceWaiters(String thread){
        waitername = thread;
        t = new Thread (this, waitername);
        System.out.println("New thread :" + t);
        t.start();
    }

    @Override
    public void run() {
        while(true){
            try
            {
              //System.out.println("Waiter thread entered");
                //generate orders
                var order = OrderGenerator.GenerateOrder();
                //var orderId = order.getId();
              // System.out.println(order.getId());
               //send orders to kitchen
                OrderGenerator.sendOrders(order);
                Thread.sleep(3000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

}
