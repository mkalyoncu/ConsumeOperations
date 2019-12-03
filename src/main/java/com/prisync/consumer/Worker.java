package com.prisync.consumer;

import com.prisync.environment.EndPoint;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Worker extends EndPoint implements Runnable {

    public Worker() throws IOException, TimeoutException {
        super();
    }

    @Override
    public void run() {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [*] Message has been received '" + message + "'");
            try {
                Thread.sleep(100);
            } catch (InterruptedException _ignored) {
                Thread.currentThread().interrupt();
            } finally {
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };
        try {
            channel.basicConsume(rmqQueueName, false, deliverCallback, consumerTag -> {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}