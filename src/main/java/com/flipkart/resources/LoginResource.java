package com.flipkart.resources;

import com.flipkart.bean.User;
import com.flipkart.dao.UserGMSDao;
import com.flipkart.response.customResponse;
import com.flipkart.response.errorResponse;
import com.flipkart.service.UserService;
import com.flipkart.service.UserServiceInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;


@Path("login")
public class LoginResource {
    UserGMSDao dbService = new UserGMSDao();

    @GET
    @Path("hello")
    @Produces("application/json")
    public String hello(){
        return "Hello ";
    }

    @POST
    @Path("authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response auth(User user){
        try {
            String userName = user.getUserName();
            String password = user.getPassword();

            ArrayList<Integer> lst = new ArrayList<>();
            lst.add(dbService.authenticateUser(userName, password));
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", lst))
                    .build();
        } catch (SQLException sqlExcep) {
            System.out.println(sqlExcep);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), sqlExcep.getMessage()))
                    .build();

        } catch (Exception excep) {
            excep.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), excep.getMessage()))
                    .build();
        }


    }
}

