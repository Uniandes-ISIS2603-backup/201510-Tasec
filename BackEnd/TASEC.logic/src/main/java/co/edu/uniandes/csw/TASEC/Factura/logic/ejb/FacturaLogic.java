package co.edu.uniandes.csw.TASEC.Factura.logic.ejb;

import co.edu.uniandes.csw.TASEC.Factura.logic.api.IFacturaLogic;
import co.edu.uniandes.csw.TASEC.Factura.logic.converter.FacturaConverter;
import co.edu.uniandes.csw.TASEC.Factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.TASEC.Factura.logic.dto.FacturaPageDTO;
import co.edu.uniandes.csw.TASEC.Factura.logic.entity.FacturaEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless 
@LocalBean
public class FacturaLogic implements IFacturaLogic{

    @PersistenceContext(unitName = "FacturaClassPU")
    protected EntityManager entityManager;

    public FacturaDTO createFactura(FacturaDTO country) {
        FacturaEntity entity = FacturaConverter.persistenceDTO2Entity(country);
        entityManager.persist(entity);
        return FacturaConverter.entity2PersistenceDTO(entity);
    }

    public List<FacturaDTO> getFacturas() {
        Query q = entityManager.createQuery("select u from FacturaEntity u");
        return FacturaConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public FacturaPageDTO getFacturas(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from FacturaEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from FacturaEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        FacturaPageDTO response = new FacturaPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(FacturaConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public FacturaDTO getFactura(Long id) {
        return FacturaConverter.entity2PersistenceDTO(entityManager.find(FacturaEntity.class, id));
    }

    public void deleteFactura(Long id) {
        FacturaEntity entity = entityManager.find(FacturaEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateFactura(FacturaDTO country) {
        FacturaEntity entity = entityManager.merge(FacturaConverter.persistenceDTO2Entity(country));
        FacturaConverter.entity2PersistenceDTO(entity);
    }
}
