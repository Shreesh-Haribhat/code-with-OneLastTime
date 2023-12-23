package Rest_Client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;


@Path("/tvSeries")
public class SeriesResource {

    //Creating Proxi to fetch the detains from another website
    @RestClient
    TvSeriesProxy proxy;

    //https://api.tvmaze.com/shows/2
    @GET
    @Path("/{id}")
    public series getTvseriesbyI(@PathParam("id") int id)
    {
        return proxy.getTvSeriesByID(id);
    }

    @GET
    @Path("/naam/{name}")
    public List<series> getApiBYname(@PathParam("name") String name)
    {
        return proxy.getByNamr(name);
    }

}
