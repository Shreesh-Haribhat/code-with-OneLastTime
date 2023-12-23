package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/mobile")
public class MobileResource {

    List<Mobile> mobiles = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMobile()
    {
        //mobiles = Mobile.listAll();
        return Response.ok(mobiles).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMobile(Mobile mobile)
    {
        mobiles.add(mobile);
        return Response.ok(mobile).build();
    }

//    @PUT
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateMobile(@PathParam("id") int id,Mobile mobile)
//    {
//        mobiles = mobiles.stream().map(mob->{
//            if(mob.id == id)
//            {
//                return mobile;
//            }
//            else {
//                return mob;
//            }
//        }).collect(Collectors.toList());
//
//        return Response.ok(mobiles).build();
//    }

    @PUT
    @Path("/{oldMobileName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMobile(@PathParam("oldMobileName") String oldMobile,
                                 @QueryParam("newMobileName") String newMobile)
    {
        mobiles = mobiles.stream().map(mob ->{
            if(mob.name.equals(oldMobile))
            {
                mob.name = newMobile;
            }
            return mob;
        }).collect(Collectors.toList());

        return Response.ok(mobiles).build();
    }

//    @DELETE
//    @Path("/delete/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response DeleteMobile(@PathParam("id") int id)
//    {
//        mobiles = mobiles.stream().map(mob ->{
//            if(mob.id == id)
//            {
//                mobiles.remove(mob);
//                //return Response.ok(mob).build();
//            }
//            if(mob == null)
//            {
//                return Response.status(Response.Status.BAD_REQUEST).build();
//
//            }
//            return mob;
//        }).collect(Collectors.toList());
//    }


}
