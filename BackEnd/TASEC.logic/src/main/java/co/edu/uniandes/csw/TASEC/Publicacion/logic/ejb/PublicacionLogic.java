/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Publicacion.logic.ejb;

import co.edu.uniandes.csw.TASEC.Publicacion.logic.api.IPublicacionLogic;
import co.edu.uniandes.csw.TASEC.Publicacion.logic.converter.PublicacionConverter;
import co.edu.uniandes.csw.TASEC.Publicacion.logic.dto.PublicacionDTO;
import co.edu.uniandes.csw.TASEC.Publicacion.logic.dto.PublicacionPageDTO;
import co.edu.uniandes.csw.TASEC.Publicacion.logic.entity.PublicacionEntity;
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
public class PublicacionLogic implements IPublicacionLogic{
    @PersistenceContext(unitName = "PublicacionClassPU")
    protected EntityManager entityManager;

    public PublicacionDTO createPublicacion(PublicacionDTO detail) {
        PublicacionEntity entity = PublicacionConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return PublicacionConverter.entity2PersistenceDTO(entity);
    }

    public List<PublicacionDTO> getPublicaciones() {
        Query q = entityManager.createQuery("select u from PublicacionEntity u");
        return PublicacionConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public PublicacionPageDTO getPublicaciones(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from PublicacionEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from PublicacionEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        PublicacionPageDTO response = new PublicacionPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(PublicacionConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public PublicacionDTO getPublicacion(Long id) {
        return PublicacionConverter.entity2PersistenceDTO(entityManager.find(PublicacionEntity.class, id));
    }

    public void deletePublicacion(Long id) {
        PublicacionEntity entity = entityManager.find(PublicacionEntity.class, id);
        entityManager.remove(entity);
    }

    public void updatePublicacion(PublicacionDTO country) {
        PublicacionEntity entity = entityManager.merge(PublicacionConverter.persistenceDTO2Entity(country));
        PublicacionConverter.entity2PersistenceDTO(entity);
    }
}
