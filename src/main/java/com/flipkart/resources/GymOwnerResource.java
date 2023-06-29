package com.flipkart.resources;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.bean.User;
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
    public void registerGymOwnerResource(GymOwner owner){
        User user = new User(owner.getUsername(),owner.getPassword(),2);
        ownerDBService.registerGymOwner(user, owner);
    }

    @GET
    @Path("fetchDetail/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public GymOwner fetchOwnerDetailsResource(@PathParam("ownerId") String ownerId){
        return ownerDBService.fetchOwnerDetails(ownerId);
    }

    @GET
    @Path("fetchGym/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Gymnasium> fetchMyGymsResource(@PathParam("ownerId") String ownerId) {
        return ownerDBService.fetchMyGyms(ownerId);
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
    @Path("isApproved/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean isOwnerApproved(@PathParam("ownerId") String ownerId) {
        return ownerDBService.isOwnerApproved(ownerId);
    }
}
