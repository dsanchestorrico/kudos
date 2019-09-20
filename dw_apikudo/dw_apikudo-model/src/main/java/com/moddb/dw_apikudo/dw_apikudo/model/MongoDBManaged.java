/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.dw_apikudo.dw_apikudo.model;

import com.mongodb.client.MongoClient;
import io.dropwizard.lifecycle.Managed;

/**
 *
 * @author daniel.sanchez
 */
public class MongoDBManaged implements Managed{
     /**
     * The mongoDB client.
     */
    private MongoClient mongoClient;

    /**
     * Constructor.
     * @param mongoClient   the mongoDB client.
     */
    public MongoDBManaged(final MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public void start() throws Exception {
    }

    @Override
    public void stop() throws Exception {
        mongoClient.close();
    }
}
