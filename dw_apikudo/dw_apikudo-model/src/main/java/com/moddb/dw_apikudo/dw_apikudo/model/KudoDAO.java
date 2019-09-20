/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.dw_apikudo.dw_apikudo.model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author daniel.sanchez
 */
public class KudoDAO {

    final MongoCollection<Document> kudosCollection;

    public KudoDAO(final MongoCollection<Document> kudosCollection1) {
        this.kudosCollection = kudosCollection1;
    }

    public List<Kudo> getAll() {
        final MongoCursor<Document> kudos = kudosCollection.find().iterator();
        final List<Kudo> kudosFind = new ArrayList<>();
        try {
            while (kudos.hasNext()) {
                final Document donut = kudos.next();
                kudosFind.add(KudosMapper.map(donut));
            }
        } finally {
            kudos.close();
        }
        return kudosFind;
    }

    public void save(final Kudo kudo) {
        Calendar calendar = Calendar.getInstance();
        final Document saveKudo = new Document("id_kudo", kudo.getIdKudo())
                .append("fuente", kudo.getFuente())
                .append("destino", kudo.getDestino())
                .append("tema", kudo.getTema())
                .append("fecha", calendar.getTime())
                .append("lugar", kudo.getLugar())
                .append("texto", kudo.getTexto());
        kudosCollection.insertOne(saveKudo);
    }

    public void delete(final ObjectId id) {
        kudosCollection.deleteOne(new Document("_id", id));
    }

}
