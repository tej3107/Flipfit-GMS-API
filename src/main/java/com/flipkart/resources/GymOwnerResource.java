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
    public Response fetchOwnerDetailsResource(@PathParam("userName") String userName){
//        return ownerDBService.fetchOwnerDetails(userName);

        try{
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
    public Response fetchMyGymsResource(@PathParam("userName") String userName) {
//        return ownerDBService.fetchMyGyms(userName);

        try{
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
    public Response addGymDetailsResource(Gymnasium gym) {

        try{
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
    public Response isOwnerApproved(@PathParam("userName") String userName) {
//        return ownerDBService.isOwnerApproved(userName);
        try{
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
