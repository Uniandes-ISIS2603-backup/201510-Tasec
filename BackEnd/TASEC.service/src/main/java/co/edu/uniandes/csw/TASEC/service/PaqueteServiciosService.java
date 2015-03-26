/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.service;

import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.api.IPaqueteServiciosLogic;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.dto.PaqueteServiciosDTO;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.dto.PaqueteServiciosPageDTO;
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

@Path("/paquetes")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaqueteServiciosService {
    
    @Inject
    protected IPaqueteServiciosLogic paqLogic;

    @POST
    public PaqueteServiciosDTO createAdministrador(PaqueteServiciosDTO paq) {
        return paqLogic.createPaqueteServicios(paq);
    }

    @DELETE
    @Path("{id}")
    public void deletePaqueteServicios(@PathParam("id") Long id) {
        paqLogic.deletePaqueteServicios(id);
    }

    @GET
    public PaqueteServiciosPageDTO getPaquetesServicios(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return paqLogic.getPaquetesServicios(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public PaqueteServiciosDTO getPaqueteServicios(@PathParam("id") Long id) {
        return paqLogic.getPaqueteServicios(id);
    }

    @PUT
    public void updatePaqueteServicios(@PathParam("id") Long id, PaqueteServiciosDTO admin) {
        paqLogic.updatePaqueteServicios(admin);
    }
}
