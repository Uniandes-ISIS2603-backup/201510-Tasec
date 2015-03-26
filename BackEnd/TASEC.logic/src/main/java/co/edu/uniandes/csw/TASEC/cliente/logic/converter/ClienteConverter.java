/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Cliente.logic.converter;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author afesguerra
 */
public class ClienteConverter {
    public static ClienteDTO entity2PersistenceDTO(ClienteEntity entity) {
        if (entity != null) {
            ClienteDTO dto = new ClienteDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPopulation(entity.getPopulation());
            return dto;
        } else {
            return null;
        }
    }

    public static ClienteEntity persistenceDTO2Entity(ClienteDTO dto) {
        if (dto != null) {
            ClienteEntity entity = new ClienteEntity();
            entity.setId(dto.getId());

            entity.setName(dto.getName());

            entity.setPopulation(dto.getPopulation());

            return entity;
        } else {
            return null;
        }
    }

    public static List<CountryDTO> entity2PersistenceDTOList(List<CountryEntity> entities) {
        List<CountryDTO> dtos = new ArrayList<CountryDTO>();
        for (CountryEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<CountryEntity> persistenceDTO2EntityList(List<CountryDTO> dtos) {
        List<CountryEntity> entities = new ArrayList<CountryEntity>();
        for (CountryDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
