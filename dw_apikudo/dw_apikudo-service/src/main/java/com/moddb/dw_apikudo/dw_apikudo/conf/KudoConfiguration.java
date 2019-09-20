/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.dw_apikudo.dw_apikudo.conf;

import com.moddb.dw_apikudo.dw_apikudo.model.MongoDBConnection;
import io.dropwizard.Configuration;

/**
 *
 * @author daniel.sanchez
 */
public class KudoConfiguration extends Configuration{
    private MongoDBConnection mongoDBConnection;
    
    public MongoDBConnection getMongoDBConnection() {
        return mongoDBConnection;
    }
    
    public void setMongoDBConnection(final MongoDBConnection mongoDBConnection) {
        this.mongoDBConnection = mongoDBConnection;
    }
}
