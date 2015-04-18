/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.service;


import co.edu.uniandes.csw.TASEC.Cliente.logic.dto.ClientePageDTO;
import co.edu.uniandes.csw.TASEC.Cliente.logic.api.IClienteLogic;
import co.edu.uniandes.csw.TASEC.Cliente.logic.dto.ClienteDTO;
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
public class ClienteService {
    
    @Inject
    protected IClienteLogic clienteLogic;

    @POST
    public ClienteDTO createCliente(ClienteDTO cliente) {
        return clienteLogic.createCliente(cliente);
    }

    @DELETE
    @Path("{id}")
    public void deleteCliente(@PathParam("id") Long id) {
        clienteLogic.deleteCliente(id);
    }

    @GET
    public ClientePageDTO getClientes(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return clienteLogic.getClientes(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public ClienteDTO getCliente(@PathParam("id") Long id) {
        return clienteLogic.getCliente(id);
    }

    @PUT
    public void updatecliente(@PathParam("id") Long id, ClienteDTO cliente) {
        clienteLogic.updateCliente(cliente);
    }

}
