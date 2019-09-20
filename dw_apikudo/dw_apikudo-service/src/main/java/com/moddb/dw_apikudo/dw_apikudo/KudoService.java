/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.dw_apikudo.dw_apikudo;

import com.moddb.dw_apikudo.dw_apikudo.conf.KudoConfiguration;
import com.moddb.dw_apikudo.dw_apikudo.model.KudoDAO;
import com.moddb.dw_apikudo.dw_apikudo.model.MongoDBFactoryConnection;
import com.moddb.dw_apikudo.dw_apikudo.model.MongoDBManaged;
import com.moddb.dw_apikudo.dw_apikudo.resource.KudoResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author daniel.sanchez
 */
public class KudoService extends Application<KudoConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(KudoService.class);

    public static void main(final String[] args) throws Exception {
        LOGGER.info("Start application.");
        new KudoService().run(args);
    }

    @Override
    public void run(final KudoConfiguration t, final Environment e) throws Exception {
        final MongoDBFactoryConnection mongoDBManagerConn = new MongoDBFactoryConnection(t.getMongoDBConnection());

        final MongoDBManaged mongoDBManaged = new MongoDBManaged(mongoDBManagerConn.getClient());

        final KudoDAO kudoDAO = new KudoDAO(mongoDBManagerConn.getClient()
                .getDatabase(t.getMongoDBConnection().getDatabase())
                .getCollection("kudos"));

        e.lifecycle().manage(mongoDBManaged);
        e.jersey().register(new KudoResource(kudoDAO));
    }
}
