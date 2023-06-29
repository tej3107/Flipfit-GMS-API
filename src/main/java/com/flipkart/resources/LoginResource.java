package com.flipkart.resources;

import com.flipkart.bean.User;
import com.flipkart.service.UserService;
import com.flipkart.service.UserServiceInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("login")
public class LoginResource {
    UserServiceInterface authentication = new UserService();

    @GET
    @Path("hello")
    @Produces("application/json")
    public String hello(){
        return "Hello ";
    }

    @POST
    @Path("authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    public int auth(User user){
        return authentication.authenticateUser(user);
    }
}
