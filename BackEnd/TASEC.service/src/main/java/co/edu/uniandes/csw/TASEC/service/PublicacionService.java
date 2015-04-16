/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.service;

import co.edu.uniandes.csw.TASEC.Publicacion.logic.api.IPublicacionLogic;
import co.edu.uniandes.csw.TASEC.Publicacion.logic.dto.PublicacionDTO;
import co.edu.uniandes.csw.TASEC.Publicacion.logic.dto.PublicacionPageDTO;
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
@Path("/publicaciones")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PublicacionService {
    @Inject
    protected IPublicacionLogic publicacionLogic;
    
    @POST
    public PublicacionDTO createPublicacion(PublicacionDTO detail) {
        return publicacionLogic.createPublicacion(detail);
    }

    @DELETE
    @Path("{id}")
    public void deletePublicacion(@PathParam("id") Long id) {
        publicacionLogic.deletePublicacion(id);
    }

    @GET
    public PublicacionPageDTO getAdministrators(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return publicacionLogic.getPublicaciones(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public PublicacionDTO getAdministrator(@PathParam("id") Long id) {
        return publicacionLogic.getPublicacion(id);
    }

    @PUT
    public void updateAdministrator(@PathParam("id") Long id, PublicacionDTO admin) {
        publicacionLogic.updatePublicacion(admin);
    }
}
