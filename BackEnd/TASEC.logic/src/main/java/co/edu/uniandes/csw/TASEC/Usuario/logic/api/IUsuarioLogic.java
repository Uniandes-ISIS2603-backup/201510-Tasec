/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Usuario.logic.api;

import co.edu.uniandes.csw.TASEC.cliente.logic.api.*;
import co.edu.uniandes.csw.TASEC.Cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.TASEC.Cliente.logic.dto.ClientePageDTO;
import java.util.List;

/**
 *
 * @author afesguerra
 */
public interface IUsuarioLogic {

    public ClienteDTO createUsuario(ClienteDTO detail);

    public List<ClienteDTO> getUsuarios();

    public ClientePageDTO getUsuarios(Integer page, Integer maxRecords);

    public ClienteDTO getUsuario(Long id);

    public void deleteUsuario(Long id);

    public void updateUsuario(ClienteDTO detail);
}
