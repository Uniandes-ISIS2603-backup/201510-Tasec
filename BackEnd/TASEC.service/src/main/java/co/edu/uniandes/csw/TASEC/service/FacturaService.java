/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.service;

import co.edu.uniandes.csw.TASEC.Factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.TASEC.Factura.logic.api.IFacturaLogic;
import co.edu.uniandes.csw.TASEC.Factura.logic.dto.FacturaPageDTO;
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

@Path("/clientes")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FacturaService {
    
    @Inject
    protected IFacturaLogic facLogic;

    @POST
    public FacturaDTO createFactura(FacturaDTO factura) {
        return facLogic.createFactura(factura);
    }

    @DELETE
    @Path("{id}")
    public void deleteFactura(@PathParam("id") Long id) {
        facLogic.deleteFactura(id);
    }

    @GET
    public FacturaPageDTO getFacturas(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return facLogic.getFacturas(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public FacturaDTO getFactura(@PathParam("id") Long id) {
        return facLogic.getFactura(id);
    }

    @PUT
    public void updateFactura(@PathParam("id") Long id, FacturaDTO factura) {
        facLogic.updateFactura(factura);
    }
}
