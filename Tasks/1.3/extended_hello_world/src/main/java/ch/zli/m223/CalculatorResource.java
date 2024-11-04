package ch.zli.m223;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/calculator")
public class CalculatorResource {

    @GET
    @Path("/add/{num1}/{num2}")
    @Produces(MediaType.TEXT_PLAIN)
    public String add(@PathParam("num1") int num1, @PathParam("num2") int num2) {
        int sum = num1 + num2;
        return String.valueOf(sum);
    }
}
