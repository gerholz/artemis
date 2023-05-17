package org.apache.activemq.artemis.jms.example;

import javax.jms.JMSException;
import javax.jms.Session;

public class MySession {

    private Session session;
    MySession(MyConnection myConnection)
    {
        try {
            session = myConnection.get().createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    Session get()
    {
        return session;
    }
}
