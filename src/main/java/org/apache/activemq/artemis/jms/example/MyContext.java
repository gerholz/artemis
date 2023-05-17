package org.apache.activemq.artemis.jms.example;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyContext {

    private InitialContext initialContext;
    MyContext()
    {
        // Step 2. Create an initial context to perform the JNDI lookup.
        try {
            initialContext = new InitialContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    InitialContext get() {
        return initialContext;
    }
}
