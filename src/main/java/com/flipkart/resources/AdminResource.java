package com.flipkart.resources;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.service.*;

import javax.ws.rs.*;
import java.util.ArrayList;

@Path("admin")
public class AdminResource {
    AdminGMSInterface admin = new AdminGMSService();

    @GET
    @Path("seegymowner")
    @Produces("application/json")
    public ArrayList<GymOwner> seeAllGymOwnerResource(){
        return admin.seeAllGymOwner();
    }

    @GET
    @Path("seegym")
    @Produces("application/json")
    public ArrayList<Gymnasium> seeAllGymResource(){
        return admin.seeAllGyms();
    }

    @GET
    @Path("seegymownerpendings")
    @Produces("application/json")
    public ArrayList<GymOwner> seePendingGymOwnerRequestResource(){
        return admin.seePendingGymOwnerRequest();
    }

    @GET
    @Path("seegympendings")
    @Produces("application/json")
    public ArrayList<Gymnasium> seePendingGymRequestResource(){
        return admin.seePendingGymRequest();
    }

    @POST
    @Path("approveoneownerreq")
    public boolean approveSingleOwnerRequestResource(@QueryParam("reqId")String reqId){
        return admin.approveSingleOwnerRequest(reqId);
    }

    @POST
    @Path("approveonegymreq")
    public boolean approveSingleGymRequestResource(@QueryParam("reqId")String reqId){
        return admin.approveSingleGymRequest(reqId);
    }

    @POST
    @Path("approveallownerreq")
    public boolean approveAllOwnerRequestResource(){
        return admin.approveAllOwnerRequest();
    }

    @POST
    @Path("approveallgymreq")
    public boolean approveAllGymRequestResource(){
        return admin.approveAllGymRequest();
    }

    @POST
    @Path("blockgymowner")
    public void blockGymOwnerResource(@QueryParam("reqId")String reqId){
        admin.blockGymOwner(reqId);
    }
}
