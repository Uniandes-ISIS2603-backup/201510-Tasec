/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Mensaje.logic.converter;

import co.edu.uniandes.csw.TASEC.Mensaje.logic.dto.MensajeDTO;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.entity.MensajeEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josedanielcardenasrincon
 */
public class MensajeConverter {
    public static MensajeDTO entity2PersistenceDTO(MensajeEntity entity) {
        if (entity != null) {
            MensajeDTO dto = new MensajeDTO();
            dto.setId(entity.getId());
            dto.setAsunto(entity.getAsunto());
            dto.setNombre(entity.getNombre());
            dto.setCorreo(entity.getNombre());
            dto.setCelular(entity.getCelular());
            dto.setMensaje(entity.getMensaje());
            dto.setDestinatario(entity.getDestinatario());
            return dto;
        } else {
            return null;
        }
    }

    public static MensajeEntity persistenceDTO2Entity(MensajeDTO dto) {
        if (dto != null) {
            MensajeEntity entity = new MensajeEntity();
            
            entity.setId(dto.getId());

            entity.setAsunto(dto.getAsunto());
            
            entity.setNombre(dto.getNombre());
            
            entity.setCorreo(dto.getCorreo());
            
            entity.setCelular(dto.getCelular());
            
            entity.setMensaje(dto.getMensaje());
            
            entity.setDestinatario(dto.getDestinatario());

            return entity;
        } else {
            return null;
        }
    }

    public static List<MensajeDTO> entity2PersistenceDTOList(List<MensajeEntity> entities) {
        List<MensajeDTO> dtos = new ArrayList<MensajeDTO>();
        for (MensajeEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<MensajeEntity> persistenceDTO2EntityList(List<MensajeDTO> dtos) {
        List<MensajeEntity> entities = new ArrayList<MensajeEntity>();
        for (MensajeDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
