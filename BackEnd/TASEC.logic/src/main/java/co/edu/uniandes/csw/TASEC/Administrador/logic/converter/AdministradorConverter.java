/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Administrador.logic.converter;


import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.TASEC.Administrador.logic.dto.AdministradorDTO;
import co.edu.uniandes.csw.TASEC.Administrador.logic.entity.AdministradorEntity;
/**
 *
 * @author afesguerra
 */
public class AdministradorConverter {
    public static AdministradorDTO entity2PersistenceDTO(AdministradorEntity entity) {
        if (entity != null) {
            AdministradorDTO dto = new AdministradorDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPopulation(entity.getPopulation());
            return dto;
        } else {
            return null;
        }
    }

    public static AdministradorEntity persistenceDTO2Entity(AdministradorDTO dto) {
        if (dto != null) {
            AdministradorEntity entity = new AdministradorEntity();
            entity.setId(dto.getId());

            entity.setName(dto.getName());

            entity.setPopulation(dto.getPopulation());

            return entity;
        } else {
            return null;
        }
    }

    public static List<AdministradorDTO> entity2PersistenceDTOList(List<AdministradorEntity> entities) {
        List<AdministradorDTO> dtos = new ArrayList<AdministradorDTO>();
        for (AdministradorEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<AdministradorEntity> persistenceDTO2EntityList(List<AdministradorDTO> dtos) {
        List<AdministradorEntity> entities = new ArrayList<AdministradorEntity>();
        for (AdministradorDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
