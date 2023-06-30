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

//    @POST
//    @Path("create")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public ArrayList<String> registerCustomerResource(Customer customer) {
////        System.out.println(customer.toJson());
////        User user = new User(customer.getUsername(),customer.getPassword(),3);
//        return customerDao.registerCustomer(customer);
//    }
//
    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerCustomerResources(Customer customer) {

        try{
        ArrayList<String> registrationResult = customerDao.registerCustomer(customer);

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

    /**
     * No Usage
     * **/
    public Customer fetchCustomerDetails(String customerId) {
        return new Customer();
    }

    @GET
    @Path("fetchGym")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchGymListResource() {
        try{
            ArrayList<Gymnasium> gymList = customerDao.fetchGymList();
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", gymList))
                    .build();
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), sqlExcep.getMessage()))
                    .build();

        } catch(Exception excep) {
            excep.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), excep.getMessage()))
                    .build();
        }

    }

    @GET
    @Path("fetchGymSlot/{gymId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchAvailableSlotResource(@PathParam("gymId") String gymId) {
        try{
            ArrayList<Slots> slotList = customerDao.fetchSlotList(gymId);
            return Response.status(Response.Status.OK)
                    .entity(new customResponse<>(Response.Status.OK.getStatusCode(), "retireval successful", slotList))
                    .build();
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), sqlExcep.getMessage()))
                    .build();

        } catch(Exception excep) {
            excep.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new errorResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), excep.getMessage()))
                    .build();
        }

    }



    @GET
    @Path("bookslot/{slotId}/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public int bookSlotsResource(@PathParam("slotId")String slotId, @PathParam("userName")String userName){
        return bookSlots(slotId,userName);
    }

    public int bookSlots(String slotId, String userName) {
        if (isFull(slotId)) {
            return 1;
        } else if (alreadyBooked(slotId, userName)) {
            return 0;
        } else {
            customerDao.bookSlots(slotId, userName);
            return 2;
        }
    }
    public boolean alreadyBooked(String slotId, String userName) { return customerDao.changeGymSlot(slotId, userName); }
    public boolean isFull(String slotId) {
        return customerDao.isFull(slotId);
    }

    @GET
    @Path("booked/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<BookedSlot> bookedSlotsResource(@PathParam("userName") String userName) {
        return customerDao.bookedGymList(userName);
    }

    @POST
    @Path("delete/slot/{username}/{slotId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean deleteSlotResource(@PathParam("username") String userName, @PathParam("slotId") String slotId){
        return customerDao.deleteSlot(userName, slotId);
    }

    @POST
    @Path("update/capacity/{slotId}/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateSlotCapacity(@PathParam("slotId") String slotId, @PathParam("value")int value){
        return customerDao.updateSlotCapacity(slotId, value);
    }

}
