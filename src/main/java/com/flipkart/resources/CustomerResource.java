package com.flipkart.resources;

import com.flipkart.bean.*;
import com.flipkart.dao.CustomerGMSDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("customer")
public class CustomerResource {

    CustomerGMSDao customerDao = new CustomerGMSDao();

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerCustomerResource(Customer customer) {
//        System.out.println(customer.toJson());
        User user = new User(customer.getUsername(),customer.getPassword(),3);
        customerDao.registerCustomer(user, customer);
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
    public ArrayList<Gymnasium> fetchGymListResource() {
        return customerDao.fetchGymList();
    }

    @GET
    @Path("fetchGymSlot/{gymId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Slots> fetchAvilableSlotResource(@PathParam("gymId") String gymId) {
        return customerDao.fetchSlotList(gymId);
    }

    @GET
    @Path("bookslot/{slotId}/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public int bookSlotsResource(@PathParam("slotId")String slotId, @PathParam("customerId")String customerId){
        return bookSlots(slotId,customerId);
    }

    public int bookSlots(String slotId, String customerId) {
        if (isFull(slotId)) {
            return 1;
        } else if (alreadyBooked(slotId, customerId)) {
            return 0;
        } else {
            customerDao.bookSlots(slotId, customerId);
            return 2;
        }
    }
    public boolean alreadyBooked(String slotId, String customerId) { return customerDao.changeGymSlot(slotId, customerId); }
    public boolean isFull(String slotId) {
        return customerDao.isFull(slotId);
    }

    @GET
    @Path("booked/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<BookedSlot> bookedSlots(@PathParam("customerId") String customerId) {
        return customerDao.bookedGymList(customerId);
    }
}
