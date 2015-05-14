/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioSimpleTest;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.api.IServicioSimpleLogic;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.converter.ServicioSimpleConverter;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.dto.ServicioSimpleDTO;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.ejb.ServicioSimpleLogic;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.entity.ServicioSimpleEntity;
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
public class ServicioSimpleTest {
    public static final String DEPLOY = "Prueba";
      @Deployment
      public static JavaArchive createDeployment() {
          return ShrinkWrap.create(JavaArchive.class, DEPLOY + ".jar")
                  //Añade el paquete en el que se encuentra la clase 'SportPersistance.java'
                  .addPackage(ServicioSimpleLogic.class.getPackage())
                  //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                  .addPackage(ServicioSimpleEntity.class.getPackage())
                  //Finalmente se añaden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete mínimo
                  .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                  .addAsResource("META-INF/beans.xml", "META-INF/beans.xml");
      }
      @Inject
      private IServicioSimpleLogic ServicioSimplePersistence;
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
          em.createQuery("delete from ServicioSimpleEntity").executeUpdate();
      }
      private List<ServicioSimpleEntity> data = new ArrayList<ServicioSimpleEntity>();
      private void insertData() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          //Luego, se generan 10 datos de prueba diferentes
          for (int i = 0; i < 3; i++) {
              ServicioSimpleEntity entity = ServicioSimpleConverter.persistenceDTO2Entity(factory.manufacturePojo(ServicioSimpleDTO.class));
 
              //Persiste el objeto en base de datos
              em.persist(entity);
              //Se añade a la lista del oráculo
              data.add(entity);
          }
      }
      @Test
      public void createServicioSimpleTest() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          ServicioSimpleDTO dto = factory.manufacturePojo(ServicioSimpleDTO.class);
          ServicioSimpleDTO result = ServicioSimplePersistence.createServicioSimple(dto);
          Assert.assertNotNull(result);
          ServicioSimpleEntity entity = em.find(ServicioSimpleEntity.class, result.getId());
 
          Assert.assertEquals(dto.getCalificacion(), entity.getCalificacion());
          Assert.assertEquals(dto.getCategoria(), entity.getCategoria());
          Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
          Assert.assertEquals(dto.getHayOferta(), entity.getHayOferta());
          Assert.assertEquals(dto.getName(), entity.getName());
          Assert.assertEquals(dto.getPrecio(), entity.getPrecio());
          Assert.assertEquals(dto.getPrecioOferta(), entity.getPrecioOferta());
          Assert.assertEquals(dto.getfecha(), entity.getfecha());
          Assert.assertEquals(dto.getId(), entity.getId());
      }
      @Test
      public void getServicioSimpleesTest() {
          List<ServicioSimpleDTO> list = ServicioSimplePersistence.getServiciosSimples();
          Assert.assertEquals(list.size(), data.size());
          for (ServicioSimpleDTO dto : list) {
              boolean found = false;
              for (ServicioSimpleEntity entity : data) {
                  if (dto.getId() == entity.getId()) {
                      found = true;
                  }
             }
             Assert.assertTrue(found);
         }
     }
     @Test
     public void getServicioSimpleTest() {
         ServicioSimpleEntity entity = data.get(0);
         ServicioSimpleDTO dto = ServicioSimplePersistence.getServicioSimple(entity.getId());
         Assert.assertNotNull(dto);
          Assert.assertEquals(dto.getCalificacion(), entity.getCalificacion());
          Assert.assertEquals(dto.getCategoria(), entity.getCategoria());
          Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
          Assert.assertEquals(dto.getHayOferta(), entity.getHayOferta());
          Assert.assertEquals(dto.getName(), entity.getName());
          Assert.assertEquals(dto.getPrecio(), entity.getPrecio());
          Assert.assertEquals(dto.getPrecioOferta(), entity.getPrecioOferta());
          Assert.assertEquals(dto.getfecha(), entity.getfecha());
          Assert.assertEquals(dto.getId(), entity.getId());
     }

     @Test
     public void deleteServicioSimpleTest() {
         ServicioSimpleEntity entity = data.get(0);
         ServicioSimplePersistence.deleteServicioSimple(entity.getId());
         ServicioSimpleEntity deleted = em.find(ServicioSimpleEntity.class, entity.getId());
         Assert.assertNull(deleted);
     }
     @Test
     public void updateServicioSimpleTest() {
         ServicioSimpleEntity entity = data.get(0);
         // se instancia el generador de datos Podam
       PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
         ServicioSimpleDTO dto = factory.manufacturePojo(ServicioSimpleDTO.class);
         dto.setId(entity.getId());
         ServicioSimplePersistence.updateServicioSimple(dto);
         ServicioSimpleEntity resp = em.find(ServicioSimpleEntity.class, entity.getId());
         Assert.assertEquals(dto.getCalificacion(), entity.getCalificacion());
          Assert.assertEquals(dto.getCategoria(), entity.getCategoria());
          Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
          Assert.assertEquals(dto.getHayOferta(), entity.getHayOferta());
          Assert.assertEquals(dto.getName(), entity.getName());
          Assert.assertEquals(dto.getPrecio(), entity.getPrecio());
          Assert.assertEquals(dto.getPrecioOferta(), entity.getPrecioOferta());
          Assert.assertEquals(dto.getfecha(), entity.getfecha());
          Assert.assertEquals(dto.getId(), entity.getId());
     }
}