package pl.webapplicationKK.rest;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import pl.webapplicationKK.model.Data;
import pl.webapplicationKK.service.DataService;

/**
 * REST Web Service
 *
 * @author kasia
 */
@Path("webservices")
public class WebserviceData {

    @Context
    private UriInfo context;

    DataService dataService = new DataService();
    
    public WebserviceData() {
    }
    
    @PostConstruct
    public void webServiceDaneInitialize() {
        context.getBaseUri().toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Data> findAll() {
        return dataService.getAllData();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(String content) {
    }
}
