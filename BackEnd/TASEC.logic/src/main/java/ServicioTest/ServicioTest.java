/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioTest;
import co.edu.uniandes.csw.TASEC.Servicio.logic.api.IServicioLogic;
import co.edu.uniandes.csw.TASEC.Servicio.logic.converter.ServicioConverter;
import co.edu.uniandes.csw.TASEC.Servicio.logic.dto.ServicioDTO;
import co.edu.uniandes.csw.TASEC.Servicio.logic.ejb.ServicioLogic;
import co.edu.uniandes.csw.TASEC.Servicio.logic.entity.ServicioEntity;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
 import javax.inject.Inject;
 import javax.persistence.EntityManager;
 import javax.persistence.PersistenceContext;
 import javax.transaction.UserTransaction;
  import org.jboss.arquillian.container.test.api.Deployment;
  import org.jboss.arquillian.junit.Arquillian;
  import org.jboss.shrinkwrap.api.ShrinkWrap;
  import org.junit.Assert;
  import org.junit.Before;
  import org.junit.Test;
  import org.junit.runner.RunWith;
  import java.util.*;
  import uk.co.jemos.podam.api.PodamFactory;
  import uk.co.jemos.podam.api.PodamFactoryImpl;
 import org.jboss.shrinkwrap.api.spec.JavaArchive;
/**
 *
 * @author JuanPablo
 */
@RunWith(Arquillian.class)
public class ServicioTest {
    public static final String DEPLOY = "Prueba";
      @Deployment
      public static JavaArchive createDeployment() {
          return ShrinkWrap.create(JavaArchive.class, DEPLOY + ".jar")
                  //A�ade el paquete en el que se encuentra la clase 'SportPersistance.java'
                  .addPackage(ServicioLogic.class.getPackage())
                  //A�ade el paquete en el que se encuentra la clase 'SportEntity.java'
                  .addPackage(ServicioEntity.class.getPackage())
                  //Finalmente se a�aden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete m�nimo
                  .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                  .addAsResource("META-INF/beans.xml", "META-INF/beans.xml");
      }
      @Inject
      private IServicioLogic ServicioPersistence;
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
          em.createQuery("delete from ServicioEntity").executeUpdate();
      }
      private List<ServicioEntity> data = new ArrayList<ServicioEntity>();
      private void insertData() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          //Luego, se generan 10 datos de prueba diferentes
          for (int i = 0; i < 3; i++) {
              ServicioEntity entity = ServicioConverter.persistenceDTO2Entity(factory.manufacturePojo(ServicioDTO.class));
 
              //Persiste el objeto en base de datos
              em.persist(entity);
              //Se a�ade a la lista del or�culo
              data.add(entity);
          }
      }
      @Test
      public void createServicioTest() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          ServicioDTO dto = factory.manufacturePojo(ServicioDTO.class);
          ServicioDTO result = ServicioPersistence.createServicio(dto);
          Assert.assertNotNull(result);
          ServicioEntity entity = em.find(ServicioEntity.class, result.getId());
 
          Assert.assertEquals(dto.getCalificacion(), entity.getCalificacion());
          Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
          Assert.assertEquals(dto.getHayOferta(), entity.getHayOferta());
          Assert.assertEquals(dto.getName(), entity.getName());
          Assert.assertEquals(dto.getPrecio(), entity.getPrecio());
          Assert.assertEquals(dto.getPrecioOferta(), entity.getPrecioOferta());
          Assert.assertEquals(dto.getfecha(), entity.getfecha());
          Assert.assertEquals(dto.getId(), entity.getId());
      }
      @Test
      public void getServicioesTest() {
          List<ServicioDTO> list = ServicioPersistence.getServicios();
          Assert.assertEquals(list.size(), data.size());
          for (ServicioDTO dto : list) {
              boolean found = false;
              for (ServicioEntity entity : data) {
                  if (dto.getId() == entity.getId()) {
                      found = true;
                  }
             }
             Assert.assertTrue(found);
         }
     }
     @Test
     public void getServicioTest() {
         ServicioEntity entity = data.get(0);
         ServicioDTO dto = ServicioPersistence.getServicio(entity.getId());
         Assert.assertNotNull(dto);
          Assert.assertEquals(dto.getCalificacion(), entity.getCalificacion());
          Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
          Assert.assertEquals(dto.getHayOferta(), entity.getHayOferta());
          Assert.assertEquals(dto.getName(), entity.getName());
          Assert.assertEquals(dto.getPrecio(), entity.getPrecio());
          Assert.assertEquals(dto.getPrecioOferta(), entity.getPrecioOferta());
          Assert.assertEquals(dto.getfecha(), entity.getfecha());
          Assert.assertEquals(dto.getId(), entity.getId());
     }

     @Test
     public void deleteServicioTest() {
         ServicioEntity entity = data.get(0);
         ServicioPersistence.deleteServicio(entity.getId());
         ServicioEntity deleted = em.find(ServicioEntity.class, entity.getId());
         Assert.assertNull(deleted);
     }
     @Test
     public void updateServicioTest() {
         ServicioEntity entity = data.get(0);
         // se instancia el generador de datos Podam
       PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
         ServicioDTO dto = factory.manufacturePojo(ServicioDTO.class);
         dto.setId(entity.getId());
         ServicioPersistence.updateServicio(dto);
         ServicioEntity resp = em.find(ServicioEntity.class, entity.getId());
         Assert.assertEquals(dto.getCalificacion(), entity.getCalificacion());
          Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
          Assert.assertEquals(dto.getHayOferta(), entity.getHayOferta());
          Assert.assertEquals(dto.getName(), entity.getName());
          Assert.assertEquals(dto.getPrecio(), entity.getPrecio());
          Assert.assertEquals(dto.getPrecioOferta(), entity.getPrecioOferta());
          Assert.assertEquals(dto.getfecha(), entity.getfecha());
          Assert.assertEquals(dto.getId(), entity.getId());
     }
}