package com.webarity.main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 */
@Path("/main")
public class RestEndpoint {

    @GET
    @Path("/{p}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pong(@PathParam("p") String pong) {
        return "pong: " + pong;
    }
}
