package org.apache.activemq.artemis.jms.example;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.TextMessage;

public class MyConsumer {
    private final MessageConsumer messageConsumer;
    MyConsumer(MySession mySession, Queue queue){
        try {
            messageConsumer = mySession.get().createConsumer(queue);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    String receive(long timeout_in_ms)
    {
        try {
            TextMessage messageReceived = (TextMessage) messageConsumer.receive(timeout_in_ms);
            return messageReceived.getText();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
