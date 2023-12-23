package Rest_Client;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/")
@RegisterRestClient(baseUri = "https://api.tvmaze.com")
public interface TvSeriesProxy {
    //https://api.tvmaze.com/shows/2
    @GET
    @Path("shows/{id}")
    public series getTvSeriesByID(@PathParam("id") int id);

    //https://api.tvmaze.com/search/people?q=lauren
    @GET
    @Path("search/people")
    public List<series> getByNamr(@QueryParam("q") String name);
}
