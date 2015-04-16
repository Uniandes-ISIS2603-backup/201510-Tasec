/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.service;

import co.edu.uniandes.csw.TASEC.ThreadForo.logic.api.IThreadForoLogic;
import co.edu.uniandes.csw.TASEC.ThreadForo.logic.dto.ThreadForoDTO;
import co.edu.uniandes.csw.TASEC.ThreadForo.logic.dto.ThreadForoPageDTO;
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
@Path("/threadForos")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ThreadForoService {
    @Inject
    protected IThreadForoLogic threadForoLogic;
    
    @POST
    public ThreadForoDTO createTheadForo(ThreadForoDTO admin) {
        return threadForoLogic.createThreadForo(admin);
    }

    @DELETE
    @Path("{id}")
    public void deleteThreadForo(@PathParam("id") Long id) {
        threadForoLogic.deleteThreadForo(id);
    }

    @GET
    public ThreadForoPageDTO getAdministrators(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return threadForoLogic.getThreadForos(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public ThreadForoDTO getAdministrator(@PathParam("id") Long id) {
        return threadForoLogic.getThreadForo(id);
    }

    @PUT
    public void updateAdministrator(@PathParam("id") Long id, ThreadForoDTO admin) {
        threadForoLogic.updateThreadForo(admin);
    }
}
