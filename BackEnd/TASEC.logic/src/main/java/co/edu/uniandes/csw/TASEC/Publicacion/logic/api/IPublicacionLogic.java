/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Publicacion.logic.api;

import co.edu.uniandes.csw.TASEC.Publicacion.logic.dto.PublicacionDTO;
import co.edu.uniandes.csw.TASEC.Publicacion.logic.dto.PublicacionPageDTO;
import java.util.List;

/**
 *
 * @author josedanielcardenasrincon
 */
public interface IPublicacionLogic {
    
    public PublicacionDTO createPublicacion(PublicacionDTO detail);

    public List<PublicacionDTO> getPublicaciones();

    public PublicacionPageDTO getPublicaciones(Integer page, Integer maxRecords);

    public PublicacionDTO getPublicacion(Long id);

    public void deletePublicacion(Long id);

    public void updatePublicacion(PublicacionDTO detail);
}
