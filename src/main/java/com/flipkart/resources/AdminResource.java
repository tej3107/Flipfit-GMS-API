package com.flipkart.resources;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.dao.AdminGMSDao;
import com.flipkart.response.customResponse;
import com.flipkart.response.errorResponse;
import com.flipkart.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("admin")
public class AdminResource {
//    AdminGMSInterface admin = new AdminGMSService();
    AdminGMSDao adminDBService = new AdminGMSDao();
    AdminGMSInterface admin = new AdminGMSService();
    SessionAuthentication session = new SessionAuthentication();
    @GET
    @Path("seegymowner")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response seeAllGymOwnerResource(@HeaderParam("Authorization") String sessionToken){
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<GymOwner> gymOwners = adminDBService.fetchGymOwnerDetails();

            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", gymOwners))
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

    @GET
    @Path("seegym")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response seeAllGymResource(@HeaderParam("Authorization") String sessionToken){
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Gymnasium> gyms = adminDBService.fetchGymnasiumDetails();

            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", gyms))
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


    @GET
    @Path("seegymownerpendings")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response seePendingGymOwnerRequestResource(@HeaderParam("Authorization") String sessionToken){
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<GymOwner> gymOwnerRequests = adminDBService.fetchPendingGymOwnerRequests();

            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", gymOwnerRequests))
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

    @GET
    @Path("seegympendings")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response seePendingGymRequestResource(@HeaderParam("Authorization") String sessionToken){
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Gymnasium> pendingGymRequests = adminDBService.fetchPendingGymnasiumRequest();

            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", pendingGymRequests))
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
    @Path("approveoneownerreq")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response approveSingleOwnerRequestResource(@HeaderParam("Authorization") String sessionToken, @QueryParam("userName")String userName){
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Boolean> booleanList = new ArrayList<>();
            booleanList.add(adminDBService.updateSingleGymOwnerRequests(userName));
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", booleanList))
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
    @Path("approveonegymreq")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response approveSingleGymRequestResource(@HeaderParam("Authorization") String sessionToken, @QueryParam("GymnasiumId")String GymnasiumId){
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Boolean> booleanList = new ArrayList<>();
            booleanList.add(adminDBService.updateSingleGymnasiumRequests(GymnasiumId));
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", booleanList))
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
    @Path("approveallownerreq")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response approveAllOwnerRequestResource(@HeaderParam("Authorization") String sessionToken){
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Boolean> booleanList = new ArrayList<>();
            booleanList.add(adminDBService.updateAllPendingGymOwnerRequests());
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", booleanList))
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
    @Path("approveallgymreq")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response approveAllGymRequestResource(@HeaderParam("Authorization") String sessionToken) {
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }

            ArrayList<Boolean> booleanList = new ArrayList<>();
            booleanList.add(adminDBService.updateAllPendingGymnasiumRequests());
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retrieval successful", booleanList))
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
    @Path("blockgymowner")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response blockGymOwnerResource(@HeaderParam("Authorization") String sessionToken, @QueryParam("userName")String userName){
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Boolean> booleanList = new ArrayList<>();
            booleanList.add(adminDBService.unApproveGymOwner(userName));
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", booleanList))
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
