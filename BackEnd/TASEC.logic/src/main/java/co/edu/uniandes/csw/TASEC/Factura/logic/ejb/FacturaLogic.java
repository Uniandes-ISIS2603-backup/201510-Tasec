package co.edu.uniandes.csw.TASEC.Cliente.logic.ejb;

import co.edu.uniandes.csw.TASEC.cliente.logic.api.IClienteLogic;
import co.edu.uniandes.csw.TASEC.Cliente.logic.converter.ClienteConverter;
import co.edu.uniandes.csw.TASEC.Cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.TASEC.Cliente.logic.dto.ClientePageDTO;
import co.edu.uniandes.csw.TASEC.Cliente.logic.entity.ClienteEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless 
@LocalBean
public class ClienteLogic implements IClienteLogic{

    @PersistenceContext(unitName = "SportClassPU")
    protected EntityManager entityManager;

    public ClienteDTO createCountry(ClienteDTO country) {
        ClienteEntity entity = ClienteConverter.persistenceDTO2Entity(country);
        entityManager.persist(entity);
        return ClienteConverter.entity2PersistenceDTO(entity);
    }

    public List<ClienteDTO> getCountries() {
        Query q = entityManager.createQuery("select u from CountryEntity u");
        return ClienteConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public ClientePageDTO getCountries(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from CountryEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from CountryEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        ClientePageDTO response = new ClientePageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(ClienteConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public ClienteDTO getCountry(Long id) {
        return ClienteConverter.entity2PersistenceDTO(entityManager.find(ClienteEntity.class, id));
    }

    public void deleteCountry(Long id) {
        ClienteEntity entity = entityManager.find(ClienteEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateCountry(ClienteDTO country) {
        ClienteEntity entity = entityManager.merge(ClienteConverter.persistenceDTO2Entity(country));
        ClienteConverter.entity2PersistenceDTO(entity);
    }

    public ClienteDTO getMostPopulated() {
        Query query = entityManager.createQuery("select u from CountryEntity u WHERE u.population = (SELECT MAX(v.population) from CountryEntity v)");
        return ClienteConverter.entity2PersistenceDTO((ClienteEntity)query.getSingleResult());
    }

    public ClienteDTO getLeastPopulated() {
        Query query = entityManager.createQuery("select u from CountryEntity u WHERE u.population = (SELECT MIN(v.population) from CountryEntity v)");
        return ClienteConverter.entity2PersistenceDTO((ClienteEntity)query.getSingleResult());
    }
}
