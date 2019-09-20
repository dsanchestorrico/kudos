/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.dw_apikudo.dw_apikudo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author daniel.sanchez
 */
public class Kudo implements Serializable {

    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    private Long idKudo;
    private Long fuente;
    private Long destino;
    private String tema;
    private Date fecha;
    private String lugar;
    private String texto;

    /**
     * @return the id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * @return the idKudo
     */
    public Long getIdKudo() {
        return idKudo;
    }

    /**
     * @param idKudo the idKudo to set
     */
    public void setIdKudo(Long idKudo) {
        this.idKudo = idKudo;
    }

    /**
     * @return the fuente
     */
    public Long getFuente() {
        return fuente;
    }

    /**
     * @param fuente the fuente to set
     */
    public void setFuente(Long fuente) {
        this.fuente = fuente;
    }

    /**
     * @return the destino
     */
    public Long getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Long destino) {
        this.destino = destino;
    }

    /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

}
