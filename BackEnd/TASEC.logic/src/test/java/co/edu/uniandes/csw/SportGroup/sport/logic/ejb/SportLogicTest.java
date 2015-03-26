/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.SportGroup.sport.logic.ejb;

import co.edu.uniandes.csw.TASEC.proveedor.logic.ejb.ProveedorLogic;
import co.edu.uniandes.csw.TASEC.Proveedor.logic.api.IProveedorLogic;
import co.edu.uniandes.csw.TASEC.Proveedor.logic.converter.ProveedorConverter;
import co.edu.uniandes.csw.TASEC.proveedor.logic.dto.ProveedroDTO;
import co.edu.uniandes.csw.TASEC.proveedor.logic.dto.ProveedorPageDTO;
import co.edu.uniandes.csw.TASEC.Proveedor.logic.entity.ProveedorEntity;
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
                .addPackage(ProveedorEntity.class.getPackage())
                .addPackage(ProveedroDTO.class.getPackage())
                .addPackage(ProveedorConverter.class.getPackage())
                .addPackage(IProveedorLogic.class.getPackage())
                .addPackage(ProveedorLogic.class.getPackage())
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

    private List<ProveedorEntity> data = new ArrayList<ProveedorEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ProveedorEntity entity = new ProveedorEntity();
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
        ProveedroDTO dto = new ProveedroDTO();
        dto.setName(generateRandom(String.class));
        dto.setMinAge(generateRandom(Integer.class));
        dto.setMaxAge(generateRandom(Integer.class));
        dto.setCountry(generateRandom(Long.class));

        ProveedroDTO result = sportLogic.createSport(dto);

        Assert.assertNotNull(result);

        ProveedorEntity entity = em.find(ProveedorEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getMinAge(), entity.getMinAge());
        Assert.assertEquals(dto.getMaxAge(), entity.getMaxAge());
    }

    @Test
    public void getSportsTest() {
        List<ProveedroDTO> list = sportLogic.getSports();
        Assert.assertEquals(list.size(), data.size());
        for (ProveedroDTO dto : list) {
            boolean found = false;
            for (ProveedorEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getSportTest() {
        ProveedorEntity entity = data.get(0);
        ProveedroDTO dto = sportLogic.getSport(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getMinAge(), dto.getMinAge());
        Assert.assertEquals(entity.getMaxAge(), dto.getMaxAge());

    }

    @Test
    public void deleteSportTest() {
        ProveedorEntity entity = data.get(0);
        sportLogic.deleteSport(entity.getId());
        ProveedorEntity deleted = em.find(ProveedorEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateSportTest() {
        ProveedorEntity entity = data.get(0);

        ProveedroDTO dto = new ProveedroDTO();
        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setMinAge(generateRandom(Integer.class));
        dto.setMaxAge(generateRandom(Integer.class));
        dto.setCountry(generateRandom(Long.class));

        sportLogic.updateSport(dto);

        ProveedorEntity resp = em.find(ProveedorEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getMinAge(), resp.getMinAge());
        Assert.assertEquals(dto.getMaxAge(), resp.getMaxAge());
    }

    @Test
    public void getSportPaginationTest() {
        //Page 1
        ProveedorPageDTO dto1 = sportLogic.getSports(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(dto1.getRecords().size(), 2);
        Assert.assertEquals(dto1.getTotalRecords().longValue(), 3L);
        //Page 2
        ProveedorPageDTO dto2 = sportLogic.getSports(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(dto2.getRecords().size(), 1);
        Assert.assertEquals(dto2.getTotalRecords().longValue(), 3L);

        for (ProveedroDTO dto : dto1.getRecords()) {
            boolean found = false;
            for (ProveedorEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ProveedroDTO dto : dto2.getRecords()) {
            boolean found = false;
            for (ProveedorEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

}
