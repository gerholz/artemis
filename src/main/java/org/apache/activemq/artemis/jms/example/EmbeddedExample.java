/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.artemis.jms.example;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import java.util.Date;

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.ActiveMQServer;
import org.apache.activemq.artemis.core.server.ActiveMQServers;

/**
 * This example demonstrates how to run an embedded ActiveMQ Artemis broker with programmatic configuration
 */
public final class EmbeddedExample {

   public static void main(final String[] args) throws Exception {

      Broker.start();

      MyContext myContext = new MyContext();
      // Step 3. Look-up the JMS queue
      Queue queue = (Queue) myContext.get().lookup("queue/exampleQueue");

      // Step 4. Look-up the JMS connection factory


      // Step 5. Send and receive a message using JMS API

      MyConnection myConnection = new MyConnection(myContext);

      try {


         MySession mySession = new MySession(myConnection);

         MyProducer myProducer = new MyProducer(mySession, queue);
         myProducer.send("Hello sent at " + new Date());


         MyConsumer myConsumer = new MyConsumer(mySession, queue);
         myConnection.get().start();
         System.out.println("Received message:" + myConsumer.receive(1000));
      } finally {

         myConnection.get().close();


         // Step 6. Stop the broker
         Broker.stop();
         System.out.println("Stopped the JMS Server");
      }
   }
}
