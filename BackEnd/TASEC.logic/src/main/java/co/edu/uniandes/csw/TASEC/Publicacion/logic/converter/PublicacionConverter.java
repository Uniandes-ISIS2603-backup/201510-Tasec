/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Publicacion.logic.converter;

import co.edu.uniandes.csw.TASEC.Publicacion.logic.dto.PublicacionDTO;
import co.edu.uniandes.csw.TASEC.Publicacion.logic.entity.PublicacionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josedanielcardenasrincon
 */
public class PublicacionConverter {
    public static PublicacionDTO entity2PersistenceDTO(PublicacionEntity entity) {
        if (entity != null) {
            PublicacionDTO dto = new PublicacionDTO();
            dto.setId(entity.getId());
            dto.setContenido(entity.getContenido());
            return dto;
        } else {
            return null;
        }
    }

    public static PublicacionEntity persistenceDTO2Entity(PublicacionDTO dto) {
        if (dto != null) {
            PublicacionEntity entity = new PublicacionEntity();
            entity.setId(dto.getId());

            entity.setContenido(dto.getContenido());

            return entity;
        } else {
            return null;
        }
    }

    public static List<PublicacionDTO> entity2PersistenceDTOList(List<PublicacionEntity> entities) {
        List<PublicacionDTO> dtos = new ArrayList<PublicacionDTO>();
        for (PublicacionEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<PublicacionEntity> persistenceDTO2EntityList(List<PublicacionDTO> dtos) {
        List<PublicacionEntity> entities = new ArrayList<PublicacionEntity>();
        for (PublicacionDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
