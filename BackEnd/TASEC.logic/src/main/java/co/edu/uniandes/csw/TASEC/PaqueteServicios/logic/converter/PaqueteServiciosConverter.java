/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.converter;


import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.dto.PaqueteServiciosDTO;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.entity.PaqueteServiciosEntity;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.converter.ServicioSimpleConverter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author afesguerra
 */
public class PaqueteServiciosConverter {
    public static PaqueteServiciosDTO entity2PersistenceDTO(PaqueteServiciosEntity entity) {
        if (entity != null) {
            PaqueteServiciosDTO dto = new PaqueteServiciosDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDescripcion(entity.getDescripcion());
            dto.setCalificacion(entity.getCalificacion());
            dto.setFecha(entity.getfecha());
            dto.setHayOferta(entity.getHayOferta());
            dto.setPrecio(entity.getPrecio());
            dto.setPrecioOferta(entity.getPrecioOferta());
            dto.setCupos(entity.getCupos());
            dto.setCuposRestantes(entity.getCuposRestantes());
            dto.setServicios(ServicioSimpleConverter.entity2PersistenceDTOList(entity.getServicios()));
            
            return dto;
        } else {
            return null;
        }
    }

    public static PaqueteServiciosEntity persistenceDTO2Entity(PaqueteServiciosDTO dto) {
        if (dto != null) {
            PaqueteServiciosEntity entity = new PaqueteServiciosEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setDescripcion(dto.getDescripcion());
            entity.setCalificacioin(dto.getCalificacion());
            entity.setFecha(dto.getfecha());
            entity.setHayOferta(dto.getHayOferta());
            entity.setPrecio(dto.getPrecio());
            entity.setPrecioOferta(dto.getPrecioOferta());
            entity.setCupos(dto.getCupos());
            entity.setCuposRestantes(dto.getCuposRestantes());
            entity.setServicios(ServicioSimpleConverter.persistenceDTO2EntityList(dto.getServicios()));

            return entity;
        } else {
            return null;
        }
    }

    public static List<PaqueteServiciosDTO> entity2PersistenceDTOList(List<PaqueteServiciosEntity> entities) {
        List<PaqueteServiciosDTO> dtos = new ArrayList<PaqueteServiciosDTO>();
        for (PaqueteServiciosEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<PaqueteServiciosEntity> persistenceDTO2EntityList(List<PaqueteServiciosDTO> dtos) {
        List<PaqueteServiciosEntity> entities = new ArrayList<PaqueteServiciosEntity>();
        for (PaqueteServiciosDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
