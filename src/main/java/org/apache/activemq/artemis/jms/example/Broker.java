package org.apache.activemq.artemis.jms.example;

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.ActiveMQServer;
import org.apache.activemq.artemis.core.server.ActiveMQServers;

public class Broker {

    static ActiveMQServer server;
    static void start() {
        try {
            // Step 1. Configure and start the embedded broker.
            server = ActiveMQServers.newActiveMQServer(new ConfigurationImpl()
                    .setPersistenceEnabled(false)
                    .setJournalDirectory("target/data/journal")
                    .setSecurityEnabled(false)
                    .addAcceptorConfiguration("invm", "vm://0"));
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void stop()
    {
        try {
            server.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
