/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.ThreadForo.logic.converter;

import co.edu.uniandes.csw.TASEC.ThreadForo.logic.dto.ThreadForoDTO;
import co.edu.uniandes.csw.TASEC.ThreadForo.logic.entity.ThreadForoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josedanielcardenasrincon
 */
public class ThreadForoConverter {
    public static ThreadForoDTO entity2PersistenceDTO(ThreadForoEntity entity) {
        if (entity != null) {
            ThreadForoDTO dto = new ThreadForoDTO();
            dto.setId(entity.getId());
            dto.setTema(entity.getTema());
            dto.setTitulo(entity.getTitulo());
            return dto;
        } else {
            return null;
        }
    }

    public static ThreadForoEntity persistenceDTO2Entity(ThreadForoDTO dto) {
        if (dto != null) {
            ThreadForoEntity entity = new ThreadForoEntity();
            entity.setId(dto.getId());
            entity.setTema(dto.getTema());
            entity.setTitulo(dto.getTitulo());

            return entity;
        } else {
            return null;
        }
    }

    public static List<ThreadForoDTO> entity2PersistenceDTOList(List<ThreadForoEntity> entities) {
        List<ThreadForoDTO> dtos = new ArrayList<ThreadForoDTO>();
        for (ThreadForoEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<ThreadForoEntity> persistenceDTO2EntityList(List<ThreadForoDTO> dtos) {
        List<ThreadForoEntity> entities = new ArrayList<ThreadForoEntity>();
        for (ThreadForoDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
