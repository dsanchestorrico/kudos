/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.dw_apikudo.dw_apikudo.model;

import java.util.Objects;

/**
 *
 * @author daniel.sanchez
 */
public class Seed {

    /**
     * The host.
     */
    private String host;

    /**
     * The port.
     */
    private int port;

    /**
     * Constructor.
     */
    public Seed() {
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Seed seed = (Seed) o;
        return port == seed.port
                && Objects.equals(host, seed.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port);
    }

    /**
     * Gets the host.
     *
     * @return the host.
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the host.
     *
     * @param host the host.
     */
    public void setHost(final String host) {
        this.host = host;
    }

    /**
     * Gets the port.
     *
     * @return the port.
     */
    public int getPort() {
        return port;
    }

    /**
     * Sets the port.
     *
     * @param port the
     */
    public void setPort(final int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Seed{"
                + "host='" + host + '\''
                + ", port=" + port
                + '}';
    }
}
