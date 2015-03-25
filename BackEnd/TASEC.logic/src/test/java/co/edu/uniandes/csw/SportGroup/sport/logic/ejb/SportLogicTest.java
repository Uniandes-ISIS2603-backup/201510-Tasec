/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.SportGroup.sport.logic.ejb;

import co.edu.uniandes.csw.TASEC.Proveedor.logic.api.IProveedorLogic;
import co.edu.uniandes.csw.SportGroup.sport.logic.converter.SportConverter;
import co.edu.uniandes.csw.SportGroup.sport.logic.dto.SportDTO;
import co.edu.uniandes.csw.SportGroup.sport.logic.dto.SportPageDTO;
import co.edu.uniandes.csw.SportGroup.sport.logic.entity.SportEntity;
import static co.edu.uniandes.csw.SportGroup.util._TestUtil.generateRandom;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SportLogicTest {

    public static final String DEPLOY = "Prueba";

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(SportEntity.class.getPackage())
                .addPackage(SportDTO.class.getPackage())
                .addPackage(SportConverter.class.getPackage())
                .addPackage(IProveedorLogic.class.getPackage())
                .addPackage(SportLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private IProveedorLogic sportLogic;

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
        em.createQuery("delete from SportEntity").executeUpdate();
    }

    private List<SportEntity> data = new ArrayList<SportEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            SportEntity entity = new SportEntity();
            entity.setName(generateRandom(String.class));
            entity.setMinAge(generateRandom(Integer.class));
            entity.setMaxAge(generateRandom(Integer.class));
            entity.setCountry(generateRandom(Long.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createSportTest() {
        SportDTO dto = new SportDTO();
        dto.setName(generateRandom(String.class));
        dto.setMinAge(generateRandom(Integer.class));
        dto.setMaxAge(generateRandom(Integer.class));
        dto.setCountry(generateRandom(Long.class));

        SportDTO result = sportLogic.createSport(dto);

        Assert.assertNotNull(result);

        SportEntity entity = em.find(SportEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getMinAge(), entity.getMinAge());
        Assert.assertEquals(dto.getMaxAge(), entity.getMaxAge());
    }

    @Test
    public void getSportsTest() {
        List<SportDTO> list = sportLogic.getSports();
        Assert.assertEquals(list.size(), data.size());
        for (SportDTO dto : list) {
            boolean found = false;
            for (SportEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getSportTest() {
        SportEntity entity = data.get(0);
        SportDTO dto = sportLogic.getSport(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getMinAge(), dto.getMinAge());
        Assert.assertEquals(entity.getMaxAge(), dto.getMaxAge());

    }

    @Test
    public void deleteSportTest() {
        SportEntity entity = data.get(0);
        sportLogic.deleteSport(entity.getId());
        SportEntity deleted = em.find(SportEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateSportTest() {
        SportEntity entity = data.get(0);

        SportDTO dto = new SportDTO();
        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setMinAge(generateRandom(Integer.class));
        dto.setMaxAge(generateRandom(Integer.class));
        dto.setCountry(generateRandom(Long.class));

        sportLogic.updateSport(dto);

        SportEntity resp = em.find(SportEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getMinAge(), resp.getMinAge());
        Assert.assertEquals(dto.getMaxAge(), resp.getMaxAge());
    }

    @Test
    public void getSportPaginationTest() {
        //Page 1
        SportPageDTO dto1 = sportLogic.getSports(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(dto1.getRecords().size(), 2);
        Assert.assertEquals(dto1.getTotalRecords().longValue(), 3L);
        //Page 2
        SportPageDTO dto2 = sportLogic.getSports(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(dto2.getRecords().size(), 1);
        Assert.assertEquals(dto2.getTotalRecords().longValue(), 3L);

        for (SportDTO dto : dto1.getRecords()) {
            boolean found = false;
            for (SportEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (SportDTO dto : dto2.getRecords()) {
            boolean found = false;
            for (SportEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

}
