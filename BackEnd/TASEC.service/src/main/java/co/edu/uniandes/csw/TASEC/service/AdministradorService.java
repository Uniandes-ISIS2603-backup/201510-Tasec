/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.service;

import co.edu.uniandes.csw.TASEC.Administrador.logic.api.IAdministradorLogic;
import co.edu.uniandes.csw.TASEC.Administrador.logic.dto.AdministradorDTO;
import co.edu.uniandes.csw.TASEC.Administrador.logic.dto.AdministradorPageDTO;
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

@Path("/administradores")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdministradorService {
    
    @Inject
    protected IAdministradorLogic adminLogic;

    @POST
    public AdministradorDTO createAdministrador(AdministradorDTO admin) {
        return adminLogic.createAdministrador(admin);
    }

    @DELETE
    @Path("{id}")
    public void deleteAdministrator(@PathParam("id") Long id) {
        adminLogic.deleteAdministrator(id);
    }

    @GET
    public AdministradorPageDTO getAdministrators(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return adminLogic.getAdministrators(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public AdministradorDTO getAdministrator(@PathParam("id") Long id) {
        return adminLogic.getAdministrator(id);
    }

    @PUT
    public void updateAdministrator(@PathParam("id") Long id, AdministradorDTO admin) {
        adminLogic.updateAdministrator(admin);
    }
}
