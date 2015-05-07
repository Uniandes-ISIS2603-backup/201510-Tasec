/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.service;

import co.edu.uniandes.csw.TASEC.Mensaje.logic.api.IMensajeLogic;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.dto.MensajeDTO;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.dto.MensajePageDTO;
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
@Path("/mensajes")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MensajeService {
    @Inject
    protected IMensajeLogic MensajeLogic;
    
    @POST
    public MensajeDTO createMensaje(MensajeDTO detail) {
        return MensajeLogic.createMensaje(detail);
    }

    @DELETE
    @Path("{id}")
    public void deleteMensaje(@PathParam("id") Long id) {
        MensajeLogic.deleteMensaje(id);
    }

    @GET
    public MensajePageDTO getMensajes(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return MensajeLogic.getMensajes(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public MensajeDTO getMensaje(@PathParam("id") Long id) {
        return MensajeLogic.getMensaje(id);
    }

    @PUT
    public void updateMensaje(@PathParam("id") Long id, MensajeDTO mensaje) {
        MensajeLogic.updateMensaje(mensaje);
    }
}
