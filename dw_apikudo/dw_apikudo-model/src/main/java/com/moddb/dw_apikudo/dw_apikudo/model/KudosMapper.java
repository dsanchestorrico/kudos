/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.dw_apikudo.dw_apikudo.model;

import org.bson.Document;

/**
 *
 * @author daniel.sanchez
 */
class KudosMapper {
    public static Kudo map(final Document kudoDocument) {
        final Kudo kudo = new Kudo();
        kudo.setId(kudoDocument.getObjectId("_id"));
        kudo.setIdKudo(kudoDocument.getLong("id_kudo"));
        kudo.setFuente(kudoDocument.getLong("fuente"));
        kudo.setDestino(kudoDocument.getLong("destino"));
        kudo.setTema(kudoDocument.getString("tema"));
        kudo.setFecha(kudoDocument.getDate("fecha"));
        kudo.setLugar(kudoDocument.getString("lugar"));
        kudo.setTexto(kudoDocument.getString("texto"));
        return kudo;
    }
}
