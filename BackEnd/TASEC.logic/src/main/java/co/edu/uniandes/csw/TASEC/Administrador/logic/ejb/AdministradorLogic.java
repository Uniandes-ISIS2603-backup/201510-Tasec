package co.edu.uniandes.csw.TASEC.Administrador.logic.ejb;

import co.edu.uniandes.csw.TASEC.Administrador.logic.api.IAdministradorLogic;
import co.edu.uniandes.csw.TASEC.Administrador.logic.converter.AdministradorConverter;
import co.edu.uniandes.csw.TASEC.Administrador.logic.dto.AdministradorDTO;
import co.edu.uniandes.csw.TASEC.Administrador.logic.dto.AdministradorPageDTO;
import co.edu.uniandes.csw.TASEC.Administrador.logic.entity.AdministradorEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless 
@LocalBean
public class AdministradorLogic implements IAdministradorLogic{

    @PersistenceContext(unitName = "AdministradorClassPU")
    protected EntityManager entityManager;

    public AdministradorDTO createAdministrador(AdministradorDTO detail) {
        AdministradorEntity entity = AdministradorConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return AdministradorConverter.entity2PersistenceDTO(entity);
    }

    public List<AdministradorDTO> getAdministrators() {
        Query q = entityManager.createQuery("select u from AdministradorEntity u");
        return AdministradorConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public AdministradorPageDTO getAdministrators(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from AdministradorEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from AdministradorEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        AdministradorPageDTO response = new AdministradorPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(AdministradorConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public AdministradorDTO getAdministrator(Long id) {
        return AdministradorConverter.entity2PersistenceDTO(entityManager.find(AdministradorEntity.class, id));
    }

    public void deleteAdministrator(Long id) {
        AdministradorEntity entity = entityManager.find(AdministradorEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateAdministrator(AdministradorDTO country) {
        AdministradorEntity entity = entityManager.merge(AdministradorConverter.persistenceDTO2Entity(country));
        AdministradorConverter.entity2PersistenceDTO(entity);
    }

}
