/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Mensaje.logic.api;

import co.edu.uniandes.csw.TASEC.Mensaje.logic.dto.MensajeDTO;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.dto.MensajePageDTO;
import java.util.List;

/**
 *
 * @author josedanielcardenasrincon
 */
public interface IMensajeLogic {
    
    public MensajeDTO createMensaje(MensajeDTO detail);

    public List<MensajeDTO> getMensajes();

    public MensajePageDTO getMensajes(Integer page, Integer maxRecords);

    public MensajeDTO getMensaje(Long id);

    public void deleteMensaje(Long id);

    public void updateMensaje(MensajeDTO detail);
}
