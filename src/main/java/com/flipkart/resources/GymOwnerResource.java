package com.flipkart.resources;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.dao.GymOwnerGMSDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("gymOwner")
public class GymOwnerResource {
    GymOwnerGMSDao ownerDBService = new GymOwnerGMSDao();

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<String> registerGymOwnerResource(GymOwner owner){
//        User user = new User(owner.getUserName(),owner.getPassword(),2);
        return ownerDBService.registerGymOwner(owner);
    }

    @GET
    @Path("fetchDetail/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public GymOwner fetchOwnerDetailsResource(@PathParam("userName") String userName){
        return ownerDBService.fetchOwnerDetails(userName);
    }

    @GET
    @Path("fetchGym/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Gymnasium> fetchMyGymsResource(@PathParam("userName") String userName) {
        return ownerDBService.fetchMyGyms(userName);
    }

    @POST
    @Path("registerGym")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addGymDetailsResource(Gymnasium gym) {
        ArrayList<Integer> slotAvailable = new ArrayList<>(gym.getSlotAvailable());
        int capacity = gym.getCapacity();
        ownerDBService.addGymDetails(gym, slotAvailable, capacity);
    }

    @GET
    @Path("isApproved/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean isOwnerApproved(@PathParam("userName") String userName) {
        return ownerDBService.isOwnerApproved(userName);
    }
}
