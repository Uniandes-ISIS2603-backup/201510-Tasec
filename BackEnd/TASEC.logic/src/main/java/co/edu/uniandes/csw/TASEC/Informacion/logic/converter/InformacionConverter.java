/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Informacion.logic.converter;

import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.TASEC.Informacion.logic.dto.InformacionDTO;
import co.edu.uniandes.csw.TASEC.Informacion.logic.entity.InformacionEntity;

/**
 *
 * @author josedanielcardenasrincon
 */
public class InformacionConverter {
    public static InformacionDTO entity2PersistenceDTO(InformacionEntity entity) {
        if (entity != null) {
            InformacionDTO dto = new InformacionDTO();
            dto.setId(entity.getId());
            dto.setDescripcion(entity.getDescripcion());
            dto.setFoto(entity.getFoto());
            dto.setTipo(entity.getTipo());
            dto.setTitulo(entity.getTitulo());
            return dto;
        } else {
            return null;
        }
    }

    public static InformacionEntity persistenceDTO2Entity(InformacionDTO dto) {
        if (dto != null) {
            InformacionEntity entity = new InformacionEntity();
            entity.setId(dto.getId());
            entity.setDescripcion(dto.getDescripcion());
            entity.setFoto(dto.getFoto());
            entity.setTipo(dto.getTipo());
            entity.setTitulo(dto.getTitulo());

            return entity;
        } else {
            return null;
        }
    }

    public static List<InformacionDTO> entity2PersistenceDTOList(List<InformacionEntity> entities) {
        List<InformacionDTO> dtos = new ArrayList<InformacionDTO>();
        for (InformacionEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<InformacionEntity> persistenceDTO2EntityList(List<InformacionDTO> dtos) {
        List<InformacionEntity> entities = new ArrayList<InformacionEntity>();
        for (InformacionDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
