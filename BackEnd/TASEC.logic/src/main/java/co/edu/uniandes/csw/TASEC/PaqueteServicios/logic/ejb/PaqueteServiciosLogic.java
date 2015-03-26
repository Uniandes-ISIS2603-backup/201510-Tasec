package co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.ejb;

import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.api.IPaqueteServiciosLogic;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.converter.PaqueteServiciosConverter;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.dto.PaqueteServiciosDTO;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.dto.PaqueteServiciosPageDTO;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.entity.PaqueteServiciosEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless 
@LocalBean
public class PaqueteServiciosLogic implements IPaqueteServiciosLogic{

    @PersistenceContext(unitName = "SportClassPU")
    protected EntityManager entityManager;

    public PaqueteServiciosDTO createPaqueteServicios(PaqueteServiciosDTO paquete) {
        PaqueteServiciosEntity entity = PaqueteServiciosConverter.persistenceDTO2Entity(paquete);
        entityManager.persist(entity);
        return PaqueteServiciosConverter.entity2PersistenceDTO(entity);
    }

    public List<PaqueteServiciosDTO> getPaquetesServicios() {
        Query q = entityManager.createQuery("select u from PaqueteServiciosEntity u");
        return PaqueteServiciosConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public PaqueteServiciosPageDTO getPaquetesServicios(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from CountryEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from CountryEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        PaqueteServiciosPageDTO response = new PaqueteServiciosPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(PaqueteServiciosConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public PaqueteServiciosDTO getPaqueteServicios(Long id) {
        return PaqueteServiciosConverter.entity2PersistenceDTO(entityManager.find(PaqueteServiciosEntity.class, id));
    }

    public void deletePaqueteServicios(Long id) {
        PaqueteServiciosEntity entity = entityManager.find(PaqueteServiciosEntity.class, id);
        entityManager.remove(entity);
    }

    public void updatePaqueteServicios(PaqueteServiciosDTO paquete) {
        PaqueteServiciosEntity entity = entityManager.merge(PaqueteServiciosConverter.persistenceDTO2Entity(paquete));
        PaqueteServiciosConverter.entity2PersistenceDTO(entity);
    }

}
