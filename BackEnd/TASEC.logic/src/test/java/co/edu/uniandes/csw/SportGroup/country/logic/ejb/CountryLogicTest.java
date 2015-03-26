package co.edu.uniandes.csw.SportGroup.country.logic.ejb;

import co.edu.uniandes.csw.TASEC.Cliente.logic.ejb.ClienteLogic;
import co.edu.uniandes.csw.TASEC.cliente.logic.api.IClienteLogic;
import co.edu.uniandes.csw.TASEC.Cliente.logic.converter.ClienteConverter;
import co.edu.uniandes.csw.TASEC.Cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.TASEC.Cliente.logic.dto.ClientePageDTO;
import co.edu.uniandes.csw.TASEC.Cliente.logic.entity.ClienteEntity;
import static co.edu.uniandes.csw.SportGroup.util._TestUtil.*;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class CountryLogicTest {
    public static final String DEPLOY = "Prueba";

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClienteDTO.class.getPackage())
                .addPackage(ClienteConverter.class.getPackage())
                .addPackage(ClienteLogic.class.getPackage())
                .addPackage(IClienteLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private IClienteLogic countryLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    @Before
    public void configTest() {
        System.out.println("em: " + em);
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    private void clearData() {
        em.createQuery("delete from CountryEntity").executeUpdate();
    }

    private List<ClienteEntity> data = new ArrayList<ClienteEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ClienteEntity entity = new ClienteEntity();
            entity.setName(generateRandom(String.class));
            entity.setPopulation(generateRandom(Integer.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createCountryTest() {
        ClienteDTO dto = new ClienteDTO();
        dto.setName(generateRandom(String.class));
        dto.setPopulation(generateRandom(Integer.class));

        ClienteDTO result = countryLogic.createCountry(dto);

        Assert.assertNotNull(result);

        ClienteEntity entity = em.find(ClienteEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getPopulation(), entity.getPopulation());
    }

    @Test
    public void getCountrysTest() {
        List<ClienteDTO> list = countryLogic.getCountries();
        Assert.assertEquals(list.size(), data.size());
        for (ClienteDTO dto : list) {
            boolean found = false;
            for (ClienteEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getCountryTest() {
        ClienteEntity entity = data.get(0);
        ClienteDTO dto = countryLogic.getCountry(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getPopulation(), dto.getPopulation());

    }

    @Test
    public void deleteCountryTest() {
        ClienteEntity entity = data.get(0);
        countryLogic.deleteCountry(entity.getId());
        ClienteEntity deleted = em.find(ClienteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateCountryTest() {
        ClienteEntity entity = data.get(0);

        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setPopulation(generateRandom(Integer.class));

        countryLogic.updateCountry(dto);

        ClienteEntity resp = em.find(ClienteEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getPopulation(), resp.getPopulation());
    }

    @Test
    public void getCountryPaginationTest() {
        //Page 1
        ClientePageDTO dto1 = countryLogic.getCountries(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(dto1.getRecords().size(), 2);
        Assert.assertEquals(dto1.getTotalRecords().longValue(), 3L);
        //Page 2
        ClientePageDTO dto2 = countryLogic.getCountries(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(dto2.getRecords().size(), 1);
        Assert.assertEquals(dto2.getTotalRecords().longValue(), 3L);

        for (ClienteDTO dto : dto1.getRecords()) {
            boolean found = false;
            for (ClienteEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ClienteDTO dto : dto2.getRecords()) {
            boolean found = false;
            for (ClienteEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
