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

import org.app.interfaces.IBukuService;
import org.app.requests.BukuRequest;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

@Path("/v1/buku")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@SecuritySchemes(
    value = {
        @SecurityScheme(
            securitySchemeName = "apiKey",
            type = SecuritySchemeType.HTTP,
            scheme = "Bearer"
        )
    }
)
public class BukuController {
    @Inject
    IBukuService bukuService;

    @POST
    public Response createBookResponse(BukuRequest body) {
        var result = bukuService.createBook(body);

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }

    @GET
    @Path("/{id}")
    @SecurityRequirement(name = "apiKey")
    public Response getBookResponse(@PathParam("id") Long id) {
        var result = bukuService.getBook(id);

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }

    @GET
    @Path("")
    public Response getAllBookResponse() {
        var result = bukuService.getAllBooks();

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }

    @PATCH
    @Path("/{id}")
    public Response updateBookResponse(@PathParam("id") Long id, BukuRequest body) {
        var result = bukuService.updateBook(id, body);

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBookResponse(@PathParam("id") Long id) {
        var result = bukuService.deleteBook(id);

        return Response.status(Math.toIntExact(result.status)).entity(result).build();
    }
}
