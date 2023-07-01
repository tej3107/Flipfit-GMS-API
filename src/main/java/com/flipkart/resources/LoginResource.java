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
    SessionAuthentication session = new SessionAuthentication();

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

            ArrayList<String> lst = new ArrayList<>();
            lst.add(String.valueOf(dbService.authenticateUser(userName, password)));

            if(lst.get(0).equals("4")){
                lst.add(session.addValidToken(userName));
            }

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

    @POST
    @Path("logout")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logout(@HeaderParam("Authorization") String sessionToken){
        try {
            ArrayList<Boolean> booleanList = new ArrayList<>();
            booleanList.add(session.removeToken(sessionToken));
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "Registration successful", booleanList))
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

