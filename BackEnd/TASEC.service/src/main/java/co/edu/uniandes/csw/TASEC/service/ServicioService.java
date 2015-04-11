/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.service;

import co.edu.uniandes.csw.TASEC.Servicio.logic.api.IServicioLogic;
import co.edu.uniandes.csw.TASEC.Servicio.logic.dto.ServicioDTO;
import co.edu.uniandes.csw.TASEC.Servicio.logic.dto.ServicioPageDTO;
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

@Path("/servicios")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicioService {
    
    @Inject
    protected IServicioLogic ssLogic;

    @POST
    public ServicioDTO createServicioService(ServicioDTO ss) {
        return ssLogic.createServicio(ss);
    }

    @DELETE
    @Path("{id}")
    public void deleteServicio(@PathParam("id") Long id) {
        ssLogic.deleteServicio(id);
    }

    @GET
    public ServicioPageDTO getServicios(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return ssLogic.getServicios(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public ServicioDTO getServicio(@PathParam("id") Long id) {
        return ssLogic.getServicio(id);
    }
    
    @GET
    public List<ServicioDTO> getServicio() {
        return ssLogic.getServicios();
    }

    @PUT
    public void updateServicio(@PathParam("id") Long id, ServicioDTO ss) {
        ssLogic.updateServicio(ss);
    }
}
