package org.app.restclients;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/extensions")
@RegisterRestClient
public interface ExtensionService {
    @GET
    Set<Extension> getById(@QueryParam String id);  
}
