package com.example.Payment.RabbitMqReceiver;

public class RabbitMqConstants
{
    public static final String Customer_QUEUE = "customer.queue";
    public static final String Customer_EXCHANGE = "Exchange";
    public static final String Customer_KEY = "customerKey";
    public static final String ADOPT_EXCHANGE = "customer.exchange";
    public static final String Customer_QUEUE_RECEIVER_TO_Payment = "customer.queue.send.to.payment";

}
