/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.service;

import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.api.IServicioSimpleLogic;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.dto.ServicioSimpleDTO;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.dto.ServicioSimplePageDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/serviciosSimples")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicioSimpleservice {
    
    @Inject
    protected IServicioSimpleLogic ssLogic;

    @POST
    public ServicioSimpleDTO createServicioSimple(ServicioSimpleDTO ss) {
        return ssLogic.createServicioSimple(ss);
    }

    @DELETE
    @Path("{id}")
    public void deleteServicioSimple(@PathParam("id") Long id) {
        ssLogic.deleteServicioSimple(id);
    }

    @GET
    public ServicioSimplePageDTO getServiciosSimples(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return ssLogic.getServiciosSimples(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public ServicioSimpleDTO getServicioSimple(@PathParam("id") Long id) {
        return ssLogic.getServicioSimple(id);
    }
//    @GET
//    public List<ServicioSimpleDTO> getServicioSimple() {
//        return ssLogic.getServiciosSimples();
//    }

    @PUT
    public void updateServicioSimple(@PathParam("id") Long id, ServicioSimpleDTO ss) {
        ssLogic.updateServicioSimple(ss);
    }
}
