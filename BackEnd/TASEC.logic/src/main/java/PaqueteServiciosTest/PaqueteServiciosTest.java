/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteServiciosTest;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.api.IPaqueteServiciosLogic;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.converter.PaqueteServiciosConverter;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.dto.PaqueteServiciosDTO;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.ejb.PaqueteServiciosLogic;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.entity.PaqueteServiciosEntity;
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
public class PaqueteServiciosTest {
    public static final String DEPLOY = "Prueba";
      @Deployment
      public static JavaArchive createDeployment() {
          return ShrinkWrap.create(JavaArchive.class, DEPLOY + ".jar")
                  //Añade el paquete en el que se encuentra la clase 'SportPersistance.java'
                  .addPackage(PaqueteServiciosLogic.class.getPackage())
                  //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                  .addPackage(PaqueteServiciosEntity.class.getPackage())
                  //Finalmente se añaden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete mínimo
                  .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                  .addAsResource("META-INF/beans.xml", "META-INF/beans.xml");
      }
      @Inject
      private IPaqueteServiciosLogic PaqueteServiciosPersistence;
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
          em.createQuery("delete from PaqueteServiciosEntity").executeUpdate();
      }
      private List<PaqueteServiciosEntity> data = new ArrayList<PaqueteServiciosEntity>();
      private void insertData() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          //Luego, se generan 10 datos de prueba diferentes
          for (int i = 0; i < 3; i++) {
              PaqueteServiciosEntity entity = PaqueteServiciosConverter.persistenceDTO2Entity(factory.manufacturePojo(PaqueteServiciosDTO.class));
 
              //Persiste el objeto en base de datos
              em.persist(entity);
              //Se añade a la lista del oráculo
              data.add(entity);
          }
      }
      @Test
      public void createPaqueteServiciosTest() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          PaqueteServiciosDTO dto = factory.manufacturePojo(PaqueteServiciosDTO.class);
          PaqueteServiciosDTO result = PaqueteServiciosPersistence.createPaqueteServicios(dto);
          Assert.assertNotNull(result);
          PaqueteServiciosEntity entity = em.find(PaqueteServiciosEntity.class, result.getId());
 
          Assert.assertEquals(dto.getCalificacion(), entity.getCalificacion());
          Assert.assertEquals(dto.getCategoria(), entity.getCategoria());
          Assert.assertEquals(dto.getCupos(), entity.getCupos());
          Assert.assertEquals(dto.getCuposRestantes(), entity.getCuposRestantes());
          Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
          Assert.assertEquals(dto.getHayOferta(), entity.getHayOferta());
          Assert.assertEquals(dto.getName(), entity.getName());
          Assert.assertEquals(dto.getPrecio(), entity.getPrecio());
          Assert.assertEquals(dto.getPrecioOferta(), entity.getPrecioOferta());
          Assert.assertEquals(dto.getServicios(), entity.getServicios());
          Assert.assertEquals(dto.getfecha(), entity.getfecha());
          Assert.assertEquals(dto.getId(), entity.getId());
      }
      @Test
      public void getPaqueteServiciosesTest() {
          List<PaqueteServiciosDTO> list = PaqueteServiciosPersistence.getPaquetesServicios();
          Assert.assertEquals(list.size(), data.size());
          for (PaqueteServiciosDTO dto : list) {
              boolean found = false;
              for (PaqueteServiciosEntity entity : data) {
                  if (dto.getId() == entity.getId()) {
                      found = true;
                  }
             }
             Assert.assertTrue(found);
         }
     }
     @Test
     public void getPaqueteServiciosTest() {
         PaqueteServiciosEntity entity = data.get(0);
         PaqueteServiciosDTO dto = PaqueteServiciosPersistence.getPaqueteServicios(entity.getId());
         Assert.assertNotNull(dto);
          Assert.assertEquals(dto.getCalificacion(), entity.getCalificacion());
          Assert.assertEquals(dto.getCategoria(), entity.getCategoria());
          Assert.assertEquals(dto.getCupos(), entity.getCupos());
          Assert.assertEquals(dto.getCuposRestantes(), entity.getCuposRestantes());
          Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
          Assert.assertEquals(dto.getHayOferta(), entity.getHayOferta());
          Assert.assertEquals(dto.getName(), entity.getName());
          Assert.assertEquals(dto.getPrecio(), entity.getPrecio());
          Assert.assertEquals(dto.getPrecioOferta(), entity.getPrecioOferta());
          Assert.assertEquals(dto.getServicios(), entity.getServicios());
          Assert.assertEquals(dto.getfecha(), entity.getfecha());
          Assert.assertEquals(dto.getId(), entity.getId());
     }

     @Test
     public void deletePaqueteServiciosTest() {
         PaqueteServiciosEntity entity = data.get(0);
         PaqueteServiciosPersistence.deletePaqueteServicios(entity.getId());
         PaqueteServiciosEntity deleted = em.find(PaqueteServiciosEntity.class, entity.getId());
         Assert.assertNull(deleted);
     }
     @Test
     public void updatePaqueteServiciosTest() {
         PaqueteServiciosEntity entity = data.get(0);
         // se instancia el generador de datos Podam
       PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
         PaqueteServiciosDTO dto = factory.manufacturePojo(PaqueteServiciosDTO.class);
         dto.setId(entity.getId());
         PaqueteServiciosPersistence.updatePaqueteServicios(dto);
         PaqueteServiciosEntity resp = em.find(PaqueteServiciosEntity.class, entity.getId());
         Assert.assertEquals(dto.getCalificacion(), entity.getCalificacion());
          Assert.assertEquals(dto.getCategoria(), entity.getCategoria());
          Assert.assertEquals(dto.getCupos(), entity.getCupos());
          Assert.assertEquals(dto.getCuposRestantes(), entity.getCuposRestantes());
          Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
          Assert.assertEquals(dto.getHayOferta(), entity.getHayOferta());
          Assert.assertEquals(dto.getName(), entity.getName());
          Assert.assertEquals(dto.getPrecio(), entity.getPrecio());
          Assert.assertEquals(dto.getPrecioOferta(), entity.getPrecioOferta());
          Assert.assertEquals(dto.getServicios(), entity.getServicios());
          Assert.assertEquals(dto.getfecha(), entity.getfecha());
          Assert.assertEquals(dto.getId(), entity.getId());
     }
}