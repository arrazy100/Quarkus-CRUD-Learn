package org.app.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.app.interfaces.IBukuInterface;
import org.app.requests.BukuRequest;

@Path("/v1/buku")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BukuController {
    @Inject
    IBukuInterface bukuInterface;

    @POST
    public Response createBookResponse(BukuRequest body) {
        var result = bukuInterface.createBook(body);

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }

    @GET
    @Path("/{id}")
    public Response getBookResponse(@PathParam("id") Long id) {
        var result = bukuInterface.getBook(id);

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }

    @GET
    @Path("")
    public Response getAllBookResponse() {
        var result = bukuInterface.getAllBooks();

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }

    @PATCH
    @Path("/{id}")
    public Response updateBookResponse(@PathParam("id") Long id, BukuRequest body) {
        var result = bukuInterface.updateBook(id, body);

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBookResponse(@PathParam("id") Long id) {
        var result = bukuInterface.deleteBook(id);

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }
}
