/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.service;

import co.edu.uniandes.csw.TASEC.Informacion.logic.api.IInformacionLogic;
import co.edu.uniandes.csw.TASEC.Informacion.logic.dto.InformacionDTO;
import co.edu.uniandes.csw.TASEC.Informacion.logic.dto.InformacionPageDTO;
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

/**
 *
 * @author josedanielcardenasrincon
 */
@Path("/informaciones")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InformacionService {
    @Inject
    protected IInformacionLogic InformacionLogic;
    
    @POST
    public InformacionDTO createInformacion(InformacionDTO detail) {
        return InformacionLogic.createInformacion(detail);
    }

    @DELETE
    @Path("{id}")
    public void deleteInformacion(@PathParam("id") Long id) {
        InformacionLogic.deleteInformacion(id);
    }

    @GET
    public InformacionPageDTO getInformaciones(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return InformacionLogic.getInformaciones(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public InformacionDTO getInformacion(@PathParam("id") Long id) {
        return InformacionLogic.getInformacion(id);
    }

    @PUT
    public void updateInformacion(@PathParam("id") Long id, InformacionDTO informacion) {
        InformacionLogic.updateInformacion(informacion);
    }
}
