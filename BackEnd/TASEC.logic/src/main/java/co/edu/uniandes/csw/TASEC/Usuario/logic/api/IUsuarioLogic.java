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

    public ClienteDTO createCountry(ClienteDTO detail);

    public List<ClienteDTO> getCountries();

    public ClientePageDTO getCountries(Integer page, Integer maxRecords);

    public ClienteDTO getCountry(Long id);

    public void deleteCountry(Long id);

    public void updateCountry(ClienteDTO detail);
    
    public ClienteDTO getMostPopulated();
    
    public ClienteDTO getLeastPopulated();
}
