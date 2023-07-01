package com.flipkart.resources;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.dao.GymOwnerGMSDao;
import com.flipkart.exception.userNameAlreadyExist;
import com.flipkart.response.customResponse;
import com.flipkart.response.errorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("gymOwner")
public class GymOwnerResource {
    GymOwnerGMSDao ownerDBService = new GymOwnerGMSDao();
    SessionAuthentication session = new SessionAuthentication();

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerGymOwnerResource(GymOwner owner){
//        User user = new User(owner.getUserName(),owner.getPassword(),2);

        try{

            ArrayList<String> registrationResult = ownerDBService.registerGymOwner(owner);

//        if (registrationResult.get(0).equals("true")) {
//            // Build a successful response with the data
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "Registration successful", registrationResult))
                    .build();
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), sqlExcep.getMessage()))
                    .build();

        } catch(userNameAlreadyExist excep) {
            excep.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), excep.getMessage()))
                    .build();
        }
        catch(Exception excep) {
            excep.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), excep.getMessage()))
                    .build();
        }

    }

    @GET
    @Path("fetchDetail/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchOwnerDetailsResource(@HeaderParam("Authorization") String sessionToken, @PathParam("userName") String userName){
//        return ownerDBService.fetchOwnerDetails(userName);

        try{
            if (!session.isValidToken(sessionToken)) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            GymOwner gymOwner = ownerDBService.fetchOwnerDetails(userName);
            ArrayList<GymOwner> gymOwnerList = new ArrayList<>();
            gymOwnerList.add(gymOwner);

//        if (registrationResult.get(0).equals("true")) {
//            // Build a successful response with the data
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retrieval successful", gymOwnerList))
                    .build();
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), sqlExcep.getMessage()))
                    .build();

        }
        catch(Exception excep) {
            excep.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), excep.getMessage()))
                    .build();
        }

    }

    @GET
    @Path("fetchGym/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchMyGymsResource(@HeaderParam("Authorization") String sessionToken, @PathParam("userName") String userName) {
//        return ownerDBService.fetchMyGyms(userName);

        try{
            if (!session.isValidToken(sessionToken)) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Gymnasium> gyms = ownerDBService.fetchMyGyms(userName);

//        if (gyms.get(0).equals("true")) {
//            // Build a successful response with the data
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retrieval successful", gyms))
                    .build();
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), sqlExcep.getMessage()))
                    .build();

        }
        catch(Exception excep) {
            excep.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), excep.getMessage()))
                    .build();
        }

    }

    @POST
    @Path("registerGym")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGymDetailsResource(@HeaderParam("Authorization") String sessionToken, Gymnasium gym) {

        try{
            if (!session.isValidToken(sessionToken)) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Integer> slotAvailable = new ArrayList<>(gym.getSlotAvailable());
            int capacity = gym.getCapacity();
            ownerDBService.addGymDetails(gym, slotAvailable, capacity);
            ArrayList<Integer> addGym = new ArrayList<>();
//        if (registrationResult.get(0).equals("true")) {
//            // Build a successful response with the data
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retrieval successful", addGym))
                    .build();
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), sqlExcep.getMessage()))
                    .build();

        }
        catch(Exception excep) {
            excep.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), excep.getMessage()))
                    .build();
        }
    }

    @GET
    @Path("isApproved/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isOwnerApproved(@HeaderParam("Authorization") String sessionToken, @PathParam("userName") String userName) {
//        return ownerDBService.isOwnerApproved(userName);
        try{
            if (!session.isValidToken(sessionToken)) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            boolean approved = ownerDBService.isOwnerApproved(userName);
            ArrayList<Boolean> approvedList = new ArrayList<>();
            approvedList.add(approved);

//        if (registrationResult.get(0).equals("true")) {
//            // Build a successful response with the data
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retrieval successful", approvedList))
                    .build();
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), sqlExcep.getMessage()))
                    .build();

        }
        catch(Exception excep) {
            excep.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), excep.getMessage()))
                    .build();
        }
    }
}
