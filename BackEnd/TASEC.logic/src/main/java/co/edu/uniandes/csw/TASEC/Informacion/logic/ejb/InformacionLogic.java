/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.TASEC.Informacion.logic.ejb;

/**
 *
 * @author josedanielcardenasrincon
 */
import co.edu.uniandes.csw.TASEC.Informacion.logic.api.IInformacionLogic;
import co.edu.uniandes.csw.TASEC.Informacion.logic.converter.InformacionConverter;
import co.edu.uniandes.csw.TASEC.Informacion.logic.dto.InformacionDTO;
import co.edu.uniandes.csw.TASEC.Informacion.logic.dto.InformacionPageDTO;
import co.edu.uniandes.csw.TASEC.Informacion.logic.entity.InformacionEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless 
@LocalBean
public class InformacionLogic implements IInformacionLogic{
    @PersistenceContext(unitName = "TasecClassPU")
    protected EntityManager entityManager;

    public InformacionDTO createInformacion(InformacionDTO detail) {
        InformacionEntity entity = InformacionConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return InformacionConverter.entity2PersistenceDTO(entity);
    }

    public List<InformacionDTO> getInformaciones() {
        Query q = entityManager.createQuery("select u from InformacionEntity u");
        return InformacionConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public InformacionPageDTO getInformaciones(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from InformacionEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from InformacionEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        InformacionPageDTO response = new InformacionPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(InformacionConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public InformacionDTO getInformacion(Long id) {
        return InformacionConverter.entity2PersistenceDTO(entityManager.find(InformacionEntity.class, id));
    }

    public void deleteInformacion(Long id) {
        InformacionEntity entity = entityManager.find(InformacionEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateInformacion(InformacionDTO country) {
        InformacionEntity entity = entityManager.merge(InformacionConverter.persistenceDTO2Entity(country));
        InformacionConverter.entity2PersistenceDTO(entity);
    }
}
