/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.service;

import co.edu.uniandes.csw.TASEC.Proveedor.logic.api.IProveedorLogic;
import co.edu.uniandes.csw.TASEC.Proveedor.logic.dto.ProveedorDTO;
import co.edu.uniandes.csw.TASEC.Proveedor.logic.dto.ProveedorPageDTO;
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

@Path("/proveedores")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProveedorService {
    
    @Inject
    protected IProveedorLogic provLogic;

    @POST
    public ProveedorDTO createProveedor(ProveedorDTO prov) {
        return provLogic.createProveedor(prov);
    }

    @DELETE
    @Path("{id}")
    public void deleteProveedor(@PathParam("id") Long id) {
        provLogic.deleteProveedor(id);
    }

    @GET
    public ProveedorPageDTO getProveedores(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return provLogic.getProveedores(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public ProveedorDTO getProveedor(@PathParam("id") Long id) {
        return provLogic.getProveedor(id);
    }

    @PUT
    public void updateProveedor(@PathParam("id") Long id, ProveedorDTO admin) {
        provLogic.updateProveedor(admin);
    }
}
