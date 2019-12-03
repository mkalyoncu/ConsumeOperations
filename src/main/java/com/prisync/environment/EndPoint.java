package com.prisync.environment;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

public abstract class EndPoint {

    protected Channel channel;
    protected Connection connection;
    protected String rmqQueueName;

    public EndPoint() throws IOException, TimeoutException {

        Properties properties = new PropertiesReader().getProperty();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(properties.getProperty("rabbitmq_ip"));
        factory.setPassword(properties.getProperty("rabbitmq_password"));
        factory.setUsername(properties.getProperty("rabbitmq_username"));

        rmqQueueName = properties.getProperty("rabbitmq_queue_name");

        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.basicQos(1);
        channel.queueDeclare(rmqQueueName, true, false, false, null);

    }
}