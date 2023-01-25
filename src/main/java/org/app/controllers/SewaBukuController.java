package org.app.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.app.interfaces.ISewaBukuInterface;
import org.app.requests.SewaBukuRequest;
import org.app.requests.TambahBukuRequest;

@Path("/v1/sewaBuku")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SewaBukuController {
    @Inject
    ISewaBukuInterface sewaBukuService;

    @POST
    public Response createBookResponse(SewaBukuRequest body) {
        var result = sewaBukuService.createSewaBuku(body);

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }

    @GET
    @Path("/{id}")
    public Response getBookResponse(@PathParam("id") Long id) {
        var result = sewaBukuService.getSewaBuku(id);

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }

    @POST
    @Path("/add/{id}")
    public Response addBookResponse(@PathParam("id") Long id, TambahBukuRequest body) {
        var result = sewaBukuService.addBuku(id, body.bukuId);

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }
}
