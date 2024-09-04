package com.snapwork.SBI.Controller;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.snapwork.SBI.FipDetailsClient;
import com.snapwork.SBI.model.TransactionResponse;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/fip")
public class FipController {

	@Inject
	@RestClient
	FipDetailsClient fipDetailsClient;

	@GET
	@Path("/getFipDetails/{accountNumber}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTransaction(@PathParam("accountNumber") String accountNumber) { 
		System.out.println("Account Number getTransaction:: " + accountNumber); 
		return accountNumber;
	}

	@GET
	@Path("/getTransaction/{accountNumber}")
	@Produces(MediaType.TEXT_PLAIN)
	public Uni<String> doTransaction(@PathParam("accountNumber") String accountNumber) {
		System.out.println("Account Number doTransaction:: " + accountNumber);
		//Uni<String> response = fipDetailsClient.getResponse(accountNumber);
		//return	response;
		
		return fipDetailsClient.getResponse(accountNumber)
				.onItem().transform(
						i -> 
						{
							System.out.println("Received Details :: "+i);
							return i;
						})
				.onFailure().invoke(
						r-> System.out.println("Failed Received Details :: "+r.getMessage()) 
						);
				
		
		//.onItem.  
		//( i -> syso)
		//.onFailure(e -> e);
		//return accountNumber;
	}

}
