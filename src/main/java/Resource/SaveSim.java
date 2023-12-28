package Resource;

import Entity.SimCard;
import Repository.SimRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/")
public class SaveSim {



//    @GET
//    @Path("save")
//    @Produces(MediaType.TEXT_PLAIN)
//    @Transactional
//    public Response saveSim()
//    {
//        String[] providers = {"Airtle","Jio","Vodaphone","HathWay","Aircle","Idea","BSNL"};
//        Boolean[] isActive = {true,false,true,false,false,true};
//
//        for(Long i=0L;i<20L;i++)
//        {
//            SimCard sim = new SimCard();
//            sim.setActive(isActive[(int) (isActive.length/2L+i)%isActive.length]);
//            sim.setProvider(providers[(int) (providers.length/1L+i)%providers.length]);
//            sim.setNumber(353793L+i);
//            simRepository.persist(sim);
//
//            //Always we need to check if the simcard has been saved successfully or not
//            // That can be done by simple methods available in Panached repository
//            if(simRepository.isPersistent(sim))
//            {
//                System.out.println("Sim Save aged pa Bahi");
//            }
//            else
//            {
//                System.out.println("Sim save agilla nodko svalp --->");
//            }
//        }
//
//        return Response.ok(new String("<----Keep Hustling ---->")).build();
//    }
//
//    @GET
//    @Path("test_methods")
//    @Transactional
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response testMethods()
//    {
//        List<SimCard> simCardList = simRepository.listAll();
//        return Response.ok(simCardList).build();
//    }
    @Inject
    SimRepository simRepository;

    @POST
    @Path("saveSim")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response saveSimcard(SimCard simCard)
    {
        simRepository.persist(simCard);
        if(simRepository.isPersistent(simCard))
        {
            return Response.ok(new String("Sim card saved Successfully --->")).build();
        }
        else
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("getList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getallSimList()
    {
        List<SimCard> simCardList = simRepository.listAll();
        return Response.ok(simCardList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByID(@PathParam("id") Long id)
    {
        SimCard simCard = simRepository.findById(id);
        return Response.ok(simCard).build();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countSImcard()
    {
        return Response.ok(simRepository.count()).build();
    }



}
