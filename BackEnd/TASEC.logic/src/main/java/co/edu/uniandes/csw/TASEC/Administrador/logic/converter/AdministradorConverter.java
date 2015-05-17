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
import co.edu.uniandes.csw.TASEC.Informacion.logic.converter.InformacionConverter;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.converter.MensajeConverter;
/**
 *
 * @author afesguerra
 */
public class AdministradorConverter {
    public static AdministradorDTO entity2PersistenceDTO(AdministradorEntity entity) {
        if (entity != null) {
            AdministradorDTO dto = new AdministradorDTO();
            dto.setId(entity.getId());
            dto.setLogin(entity.getLogin());
            dto.setEMail(entity.getEMail());
            dto.setNombre(entity.getNombre());
            dto.setContrasenha(entity.getContrasenha());
            dto.setEdad(entity.getEdad());
            dto.setMensajes(MensajeConverter.entity2PersistenceDTOList(entity.getMensajes()));
            dto.setInformacion(InformacionConverter.entity2PersistenceDTOList(entity.getInformacion()));
            
            return dto;
        } else {
            return null;
        }
    }

    public static AdministradorEntity persistenceDTO2Entity(AdministradorDTO dto) {
        if (dto != null) {
            AdministradorEntity entity = new AdministradorEntity();
            entity.setId(dto.getId());
            entity.setLogin(dto.getLogin());
            entity.setNombre(dto.getNombre());
            entity.setEMail(dto.getEMail());
            entity.setContrasenha(dto.getContrasenha());
            entity.setEdad(dto.getEdad());
            entity.setMensajes(MensajeConverter.persistenceDTO2EntityList(dto.getMensajes()));
            entity.setInformacion(InformacionConverter.persistenceDTO2EntityList(dto.getInformacion()));

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
