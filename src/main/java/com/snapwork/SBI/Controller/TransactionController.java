package com.snapwork.SBI.Controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/transaction")
public class TransactionController {

		@GET
	    @Path("/getTransactionDetails/{accountNumber}")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String doTransaction(@PathParam("accountNumber") String accountNumber) {
			System.out.println("Account Number ::" + accountNumber);
	        return accountNumber;
	    }
}
