/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.dw_apikudo.dw_apikudo.model;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author danielsan
 */
public class Publisher {
    private JSONParser parser;

    public Publisher() {
        parser = new JSONParser();
    }
    

    public void publishAddKudoQTY(String idUsuario) throws IOException, TimeoutException {
        String QUEUE_NAME = "ADD_KUDO_QTY";

        JSONObject jsonObject = new JSONObject();
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

                channel.basicPublish("", QUEUE_NAME, null, idUsuario.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + idUsuario + "'");
            
        }
    }
}
