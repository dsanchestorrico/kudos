/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.dw_apikudo.dw_apikudo.model;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author daniel.sanchez
 */
public class MongoDBFactoryConnection {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBFactoryConnection.class);

    /**
     * The configuration for connect to MongoDB Server.
     */
    private MongoDBConnection mongoDBConnection;

    /**
     * Constructor.
     *
     * @param mongoDBConnection the mongoDB connection data.
     */
    public MongoDBFactoryConnection(final MongoDBConnection mongoDBConnection) {
        this.mongoDBConnection = mongoDBConnection;
    }

    /**
     * Gets the connection to MongoDB.
     *
     * @return the mongo Client.
     */
    public MongoClient getClient() {
        LOGGER.info("Creating mongoDB client.");
        final Credentials configCredentials = mongoDBConnection.getCredentials();

        final MongoCredential credentials = MongoCredential.createCredential(
                configCredentials.getUsername(),
                mongoDBConnection.getDatabase(),
                configCredentials.getPassword());

        final MongoClient client = MongoClients.create(
                MongoClientSettings.builder()
                        .credential(credentials)
                        .applyToClusterSettings(builder -> builder.hosts(getServers())).build()
        );

        return client;
    }

    /**
     * Map the object {@link Seed} to objects {@link ServerAddress} that contain
     * the information of servers.
     *
     * @return the list of servers.
     */
    private List<ServerAddress> getServers() {
        final List<Seed> seeds = mongoDBConnection.getSeeds();
        return seeds.stream()
                .map(seed -> {
                    final ServerAddress serverAddress = new ServerAddress(seed.getHost(), seed.getPort());
                    return serverAddress;
                })
                .collect(Collectors.toList());
    }
}
