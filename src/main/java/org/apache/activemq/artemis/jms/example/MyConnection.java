package org.apache.activemq.artemis.jms.example;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.NamingException;

public class MyConnection {

    private Connection connection = null;
    MyConnection(MyContext myContext)
    {
        try {
            ConnectionFactory cf = (ConnectionFactory) myContext.get().lookup("ConnectionFactory");
            connection = cf.createConnection();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    Connection get()
    {
        return connection;
    }
}
