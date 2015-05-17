/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.cliente.logic.converter;


import co.edu.uniandes.csw.TASEC.Factura.logic.converter.FacturaConverter;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.converter.MensajeConverter;
import co.edu.uniandes.csw.TASEC.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.TASEC.cliente.logic.entity.ClienteEntity;
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
            dto.setLogin(entity.getLogin());
            dto.setEMail(entity.getEMail());
            dto.setNombre(entity.getNombre());
            dto.setContrasenha(entity.getContrasenha());
            dto.setEdad(entity.getEdad());
            dto.setMensajes(MensajeConverter.entity2PersistenceDTOList(entity.getMensajes()));
            dto.setSaldo(entity.getSaldo());
            dto.setDireccion(entity.getDireccion());
            dto.setTarjetaDeCredito(entity.getTarjetaDeCredito());
            dto.setTelefono(entity.getTelefono());
            dto.setComprasRealizadas(FacturaConverter.entity2PersistenceDTOList(entity.getComprasRealizadas()));
            return dto;
        
        } else {
            return null;
        }
    }

    public static ClienteEntity persistenceDTO2Entity(ClienteDTO dto) {
        if (dto != null) {
            ClienteEntity entity = new ClienteEntity();
            entity.setId(dto.getId());
            entity.setLogin(dto.getLogin());
            entity.setNombre(dto.getNombre());
            entity.setEMail(dto.getEMail());
            entity.setContrasenha(dto.getContrasenha());
            entity.setEdad(dto.getEdad());
            entity.setMensajes(MensajeConverter.persistenceDTO2EntityList(dto.getMensajes()));
            entity.setDireccion(dto.getDireccion());
            entity.setSaldo(dto.getSaldo());
            entity.setTelefono(dto.getTelefono());
            entity.setComprasRealizadas(FacturaConverter.persistenceDTO2EntityList(dto.getComprasRealizadas()));
            return entity;
        
        } else {
            return null;
        }
    }

    public static List<ClienteDTO> entity2PersistenceDTOList(List<ClienteEntity> entities) {
        List<ClienteDTO> dtos = new ArrayList<ClienteDTO>();
        for (ClienteEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<ClienteEntity> persistenceDTO2EntityList(List<ClienteDTO> dtos) {
        List<ClienteEntity> entities = new ArrayList<ClienteEntity>();
        for (ClienteDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
