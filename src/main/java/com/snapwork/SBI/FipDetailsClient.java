package com.snapwork.SBI;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

//@RegisterRestClient
@RegisterRestClient(configKey = "transaction-api") 
@Path("/fip")
public interface FipDetailsClient {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getFipDetails/{accountNumber}")
	public Uni<String> getResponse(@PathParam("accountNumber") String accountNumber); 
	
}
