/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.service;

import co.edu.uniandes.csw.TASEC.Usuario.logic.api.IUsuarioLogic;
import co.edu.uniandes.csw.TASEC.Usuario.logic.dto.UsuarioDTO;
import co.edu.uniandes.csw.TASEC.Usuario.logic.dto.UsuarioPageDTO;
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

@Path("/usuarios")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService {
    
    @Inject
    protected IUsuarioLogic uLogic;

    @POST
    public UsuarioDTO createUsuario(UsuarioDTO u) {
        return uLogic.createUsuario(u);
    }

    @DELETE
    @Path("{id}")
    public void deleteUsuario(@PathParam("id") Long id) {
        uLogic.deleteUsuario(id);
    }

    @GET
    public UsuarioPageDTO getUsuarios(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return uLogic.getUsuarios(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public UsuarioDTO getUsuario(@PathParam("id") Long id) {
        return uLogic.getUsuario(id);
    }

    @PUT
    public void updateUsuario(@PathParam("id") Long id, UsuarioDTO u) {
        uLogic.updateUsuario(u);
    }
}
