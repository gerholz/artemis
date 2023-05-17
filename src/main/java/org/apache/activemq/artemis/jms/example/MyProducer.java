package org.apache.activemq.artemis.jms.example;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.TextMessage;
import java.util.Date;

public class MyProducer {

    private final MySession mySession;
    private final MessageProducer producer;
    MyProducer(MySession mySession, Queue queue)
    {
        this.mySession = mySession;
        try {
            producer = mySession.get().createProducer(queue);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    void send(String string)
    {
        try {
            TextMessage message = mySession.get().createTextMessage(string);
            System.out.println("Sending message: " + message.getText());
            producer.send(message);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }



}
