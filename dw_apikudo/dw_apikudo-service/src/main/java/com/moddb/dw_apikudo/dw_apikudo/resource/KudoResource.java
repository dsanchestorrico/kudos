/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.dw_apikudo.dw_apikudo.resource;

import com.moddb.dw_apikudo.dw_apikudo.model.Kudo;
import com.moddb.dw_apikudo.dw_apikudo.model.KudoDAO;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author daniel.sanchez
 */
@Path("/kudo")
@Produces(MediaType.APPLICATION_JSON)
public class KudoResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(KudoResource.class);
    private KudoDAO kudoDAO;

    public KudoResource(final KudoDAO kudoDAO) {
        this.kudoDAO = kudoDAO;
    }

    @GET
    public Response all() {
        LOGGER.info("List all kudos.");
        final List<Kudo> kudosFind = kudoDAO.getAll();
        return Response.ok(kudosFind).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(final Kudo kudo) {
        LOGGER.info("Persist a kudo in collection with the information: {}", kudo);
        kudoDAO.save(kudo);
        return Response.status(Response.Status.CREATED).build();
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operation success.")
    })
    @DELETE
    @Path("/{id}")
    public Response delete(@ApiParam(value = "id") @PathParam("id") @NotNull final ObjectId id) {
        LOGGER.info("Delete a kudo from collection with identifier: " + id.toString());
        kudoDAO.delete(id);
        return Response.ok().build();
    }
}
