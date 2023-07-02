package com.flipkart.resources;

import com.flipkart.bean.BookedSlot;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Gymnasium;
import com.flipkart.bean.Slots;
import com.flipkart.dao.CustomerGMSDao;
import com.flipkart.exception.userNameAlreadyExist;
import com.flipkart.exception.userNotExist;
import com.flipkart.response.customResponse;
import com.flipkart.response.errorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("customer")
public class CustomerResource {

    CustomerGMSDao customerDao = new CustomerGMSDao();
    SessionAuthentication session = new SessionAuthentication();

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerCustomerResources(Customer customer) {

        try {
            // Check if the session token is valid

            ArrayList<String> registrationResult = customerDao.registerCustomer(customer);

//        if (registrationResult.get(0).equals("true")) {
//            // Build a successful response with the data
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "Registration successful", registrationResult))
                    .build();
        } catch (SQLException sqlExcep) {
            System.out.println(sqlExcep);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), sqlExcep.getMessage()))
                    .build();

        } catch (userNameAlreadyExist excep) {
            excep.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), excep.getMessage()))
                    .build();
        } catch (Exception excep) {
            excep.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), excep.getMessage()))
                    .build();
        }
    }

    @GET
    @Path("fetchGym")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchGymListResource(@HeaderParam("Authorization") String sessionToken) {
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Gymnasium> gymList = customerDao.fetchGymList();
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", gymList))
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
    @Path("fetchGymSlot/{gymId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchAvailableSlotResource(@HeaderParam("Authorization") String sessionToken, @PathParam("gymId") String gymId) {
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Slots> slotList = customerDao.fetchSlotList(gymId);
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", slotList))
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
    @Path("bookslot/{slotId}/{userName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookSlotsResource(@HeaderParam("Authorization") String sessionToken, @PathParam("slotId") String slotId, @PathParam("userName") String userName) {

        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Integer> lst = new ArrayList<>();
            lst.add(bookSlots(slotId, userName));
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

    public int bookSlots(String slotId, String userName) throws Exception{
        if(customerDao.sameSlotAlreadyBooked(slotId, userName)){
            return 0;
        }
        else if (isFull(slotId)) {
            return 1;
        } else if (alreadyBooked(slotId, userName)) {
            //will change slot in it
            return 2;
        } else {
            customerDao.bookSlots(slotId, userName);
            return 3;
        }
    }

    public boolean alreadyBooked(String slotId, String userName) throws Exception{
        return customerDao.changeGymSlot(slotId, userName);
    }

    public boolean isFull(String slotId) throws Exception{
        return customerDao.isFull(slotId);
    }

    @GET
    @Path("booked/{userName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookedSlotsResource(@HeaderParam("Authorization") String sessionToken, @PathParam("userName") String userName) {

        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<BookedSlot> bookedSlots = customerDao.bookedGymList(userName);
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", bookedSlots))
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
    @Path("delete/slot/{username}/{slotId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteSlotResource(@HeaderParam("Authorization") String sessionToken, @PathParam("username") String userName, @PathParam("slotId") String slotId) {
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Boolean> booleanList = new ArrayList<>();
            booleanList.add(customerDao.deleteSlot(userName, slotId));
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
    @Path("update/capacity/{slotId}/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSlotCapacity(@HeaderParam("Authorization") String sessionToken, @PathParam("slotId") String slotId, @PathParam("value") int value) {
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Boolean> booleanList = new ArrayList<>();
            booleanList.add(customerDao.updateSlotCapacity(slotId, value));
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

    @GET
    @Path("getCustomerDetails/{userName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerDetails(@HeaderParam("Authorization") String sessionToken, @PathParam("userName") String userName) {
        try {
            // Check if the session token is valid
            if (!session.isValidToken(sessionToken.substring(7))) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new errorResponse(Response.Status.UNAUTHORIZED.getStatusCode(), "Invalid session token"))
                        .build();
            }
            ArrayList<Customer> custList = new ArrayList<>();
            custList.add(customerDao.getCustomerDetails(userName));
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", custList))
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
