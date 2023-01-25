package org.app.controllers;

import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.app.restclients.Extension;
import org.app.restclients.ExtensionService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/extension")
public class ExtensionController {
    @Inject
    @RestClient
    ExtensionService extensionService;
    
    @GET
    @Path("/id/{id}")
    public Response getExtensionById(@PathParam String id) {
        Set<Extension> result = extensionService.getById(id);

        return Response.status(Math.toIntExact(200)).entity(result).build();
    }
}
