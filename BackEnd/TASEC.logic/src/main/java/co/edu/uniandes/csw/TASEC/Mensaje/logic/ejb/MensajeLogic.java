/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Mensaje.logic.ejb;

import co.edu.uniandes.csw.TASEC.Mensaje.logic.api.IMensajeLogic;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.converter.MensajeConverter;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.dto.MensajeDTO;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.dto.MensajePageDTO;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.entity.MensajeEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author josedanielcardenasrincon
 */
@Stateless 
@LocalBean
public class MensajeLogic implements IMensajeLogic{
    @PersistenceContext(unitName = "TasecClassPU")
    protected EntityManager entityManager;

    public MensajeDTO createMensaje(MensajeDTO detail) {
        MensajeEntity entity = MensajeConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return MensajeConverter.entity2PersistenceDTO(entity);
    }

    public List<MensajeDTO> getMensajes() {
        Query q = entityManager.createQuery("select u from MensajeEntity u");
        return MensajeConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public MensajePageDTO getMensajes(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from MensajeEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from MensajeEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        MensajePageDTO response = new MensajePageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(MensajeConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public MensajeDTO getMensaje(Long id) {
        return MensajeConverter.entity2PersistenceDTO(entityManager.find(MensajeEntity.class, id));
    }

    public void deleteMensaje(Long id) {
        MensajeEntity entity = entityManager.find(MensajeEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateMensaje(MensajeDTO country) {
        MensajeEntity entity = entityManager.merge(MensajeConverter.persistenceDTO2Entity(country));
        MensajeConverter.entity2PersistenceDTO(entity);
    }
}
