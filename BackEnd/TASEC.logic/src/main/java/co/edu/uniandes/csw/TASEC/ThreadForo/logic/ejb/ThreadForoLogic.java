/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.ThreadForo.logic.ejb;

import co.edu.uniandes.csw.TASEC.ThreadForo.logic.api.IThreadForoLogic;
import co.edu.uniandes.csw.TASEC.ThreadForo.logic.converter.ThreadForoConverter;
import co.edu.uniandes.csw.TASEC.ThreadForo.logic.dto.ThreadForoDTO;
import co.edu.uniandes.csw.TASEC.ThreadForo.logic.dto.ThreadForoPageDTO;
import co.edu.uniandes.csw.TASEC.ThreadForo.logic.entity.ThreadForoEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author josedanielcardenasrincon
 */
public class ThreadForoLogic implements IThreadForoLogic{

    @PersistenceContext(unitName = "ThreadForoClassPU")
    protected EntityManager entityManager;
    
    public ThreadForoDTO createThreadForo(ThreadForoDTO detail) {
        ThreadForoEntity entity = ThreadForoConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return ThreadForoConverter.entity2PersistenceDTO(entity);
    }

    public List<ThreadForoDTO> getThreadForos() {
        Query q = entityManager.createQuery("select u from ThreadForoEntity u");
        return ThreadForoConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public ThreadForoPageDTO getThreadForos(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from ThreadForoEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from ThreadForoEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        ThreadForoPageDTO response = new ThreadForoPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(ThreadForoConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public ThreadForoDTO getThreadForo(Long id) {
        return ThreadForoConverter.entity2PersistenceDTO(entityManager.find(ThreadForoEntity.class, id));
    }

    public void deleteThreadForo(Long id) {
        ThreadForoEntity entity = entityManager.find(ThreadForoEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateThreadForo(ThreadForoDTO country) {
        ThreadForoEntity entity = entityManager.merge(ThreadForoConverter.persistenceDTO2Entity(country));
        ThreadForoConverter.entity2PersistenceDTO(entity);
    }
    
}
