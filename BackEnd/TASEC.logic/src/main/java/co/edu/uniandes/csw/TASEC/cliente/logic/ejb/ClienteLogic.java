package co.edu.uniandes.csw.TASEC.Cliente.logic.ejb;

import co.edu.uniandes.csw.TASEC.Cliente.logic.api.IClienteLogic;
import co.edu.uniandes.csw.TASEC.Cliente.logic.converter.ClienteConverter;
import co.edu.uniandes.csw.TASEC.Cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.TASEC.Cliente.logic.dto.ClientePageDTO;
import co.edu.uniandes.csw.TASEC.Cliente.logic.entity.ClienteEntity;
import co.edu.uniandes.csw.TASEC.Factura.logic.dto.FacturaDTO;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless 
@LocalBean
public class ClienteLogic implements IClienteLogic{

    @PersistenceContext(unitName = "ClienteClassPU")
    protected EntityManager entityManager;

    public ClienteDTO createCliente(ClienteDTO cliente) {
        ClienteEntity entity = ClienteConverter.persistenceDTO2Entity(cliente);
        entityManager.persist(entity);
        return ClienteConverter.entity2PersistenceDTO(entity);
    }

    public List<ClienteDTO> getCliente() {
        Query q = entityManager.createQuery("select u from ClienteEntity u");
        return ClienteConverter.entity2PersistenceDTOList(q.getResultList());
    }
    
    public ClientePageDTO getClientes(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from ClienteEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from ClienteEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        ClientePageDTO response = new ClientePageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(ClienteConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public ClienteDTO getCliente(Long id) {
        return ClienteConverter.entity2PersistenceDTO(entityManager.find(ClienteEntity.class, id));
    }

    public void deleteCliente(Long id) {
        ClienteEntity entity = entityManager.find(ClienteEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateCliente(ClienteDTO cliente) {
        ClienteEntity entity = entityManager.merge(ClienteConverter.persistenceDTO2Entity(cliente));
        ClienteConverter.entity2PersistenceDTO(entity);
    }

    public List<ClienteDTO> getClientes() {
        Query q = entityManager.createQuery("select u from ClienteEntity u");
        return ClienteConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public List<FacturaDTO> getHistoricoTransacciones(Date fechaInicial, Date fechaFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
