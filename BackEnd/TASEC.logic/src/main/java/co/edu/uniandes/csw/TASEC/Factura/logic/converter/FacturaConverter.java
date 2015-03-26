/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Factura.logic.converter;


import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.TASEC.Factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.TASEC.Factura.logic.entity.FacturaEntity;
/**
 *
 * @author afesguerra
 */
public class FacturaConverter {
    public static FacturaDTO entity2PersistenceDTO(FacturaEntity entity) {
        if (entity != null) {
            FacturaDTO dto = new FacturaDTO();
            dto.setId(entity.getId());
            dto.setFecha(entity.getFecha());
            dto.setTotalAPagar(entity.getTotalAPagar());
            return dto;
        } else {
            return null;
        }
    }

    public static FacturaEntity persistenceDTO2Entity(FacturaDTO dto) {
        if (dto != null) {
            FacturaEntity entity = new FacturaEntity();
            entity.setId(dto.getId());

            entity.setFecha(dto.getFecha());

            entity.setTotalAPagar(dto.getTotalAPagar());

            return entity;
        } else {
            return null;
        }
    }

    public static List<FacturaDTO> entity2PersistenceDTOList(List<FacturaEntity> entities) {
        List<FacturaDTO> dtos = new ArrayList<FacturaDTO>();
        for (FacturaEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<FacturaEntity> persistenceDTO2EntityList(List<FacturaDTO> dtos) {
        List<FacturaEntity> entities = new ArrayList<FacturaEntity>();
        for (FacturaDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
