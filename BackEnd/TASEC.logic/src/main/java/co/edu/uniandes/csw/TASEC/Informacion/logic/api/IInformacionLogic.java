/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Informacion.logic.api;

import co.edu.uniandes.csw.TASEC.Informacion.logic.dto.InformacionDTO;
import co.edu.uniandes.csw.TASEC.Informacion.logic.dto.InformacionPageDTO;
import java.util.List;
/**
 *
 * @author josedanielcardenasrincon
 */
public interface IInformacionLogic{
    
    public InformacionDTO createInformacion(InformacionDTO detail);

    public List<InformacionDTO> getInformaciones();

    public InformacionPageDTO getInformaciones(Integer page, Integer maxRecords);

    public InformacionDTO getInformacion(Long id);

    public void deleteInformacion(Long id);

    public void updateInformacion(InformacionDTO detail);
}
