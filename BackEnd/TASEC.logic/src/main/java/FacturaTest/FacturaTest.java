/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacturaTest;
import co.edu.uniandes.csw.TASEC.Factura.logic.api.IFacturaLogic;
import co.edu.uniandes.csw.TASEC.Factura.logic.converter.FacturaConverter;
import co.edu.uniandes.csw.TASEC.Factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.TASEC.Factura.logic.ejb.FacturaLogic;
import co.edu.uniandes.csw.TASEC.Factura.logic.entity.FacturaEntity;
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
public class FacturaTest {
    public static final String DEPLOY = "Prueba";
      @Deployment
      public static JavaArchive createDeployment() {
          return ShrinkWrap.create(JavaArchive.class, DEPLOY + ".jar")
                  //Añade el paquete en el que se encuentra la clase 'SportPersistance.java'
                  .addPackage(FacturaLogic.class.getPackage())
                  //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                  .addPackage(FacturaEntity.class.getPackage())
                  //Finalmente se añaden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete mínimo
                  .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                  .addAsResource("META-INF/beans.xml", "META-INF/beans.xml");
      }
      @Inject
      private IFacturaLogic FacturaPersistence;
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
          em.createQuery("delete from FacturaEntity").executeUpdate();
      }
      private List<FacturaEntity> data = new ArrayList<FacturaEntity>();
      private void insertData() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          //Luego, se generan 10 datos de prueba diferentes
          for (int i = 0; i < 3; i++) {
              FacturaEntity entity = FacturaConverter.persistenceDTO2Entity(factory.manufacturePojo(FacturaDTO.class));
 
              //Persiste el objeto en base de datos
              em.persist(entity);
              //Se añade a la lista del oráculo
              data.add(entity);
          }
      }
      @Test
      public void createFacturaTest() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          FacturaDTO dto = factory.manufacturePojo(FacturaDTO.class);
          FacturaDTO result = FacturaPersistence.createFactura(dto);
          Assert.assertNotNull(result);
          FacturaEntity entity = em.find(FacturaEntity.class, result.getId());
 
          Assert.assertEquals(dto.getTotalAPagar(), entity.getTotalAPagar());
          Assert.assertEquals(dto.getFecha(), entity.getFecha());
          Assert.assertEquals(dto.getId(), entity.getId());
      }
      @Test
      public void getFacturaesTest() {
          List<FacturaDTO> list = FacturaPersistence.getFacturas();
          Assert.assertEquals(list.size(), data.size());
          for (FacturaDTO dto : list) {
              boolean found = false;
              for (FacturaEntity entity : data) {
                  if (dto.getId() == entity.getId()) {
                      found = true;
                  }
             }
             Assert.assertTrue(found);
         }
     }
     @Test
     public void getFacturaTest() {
         FacturaEntity entity = data.get(0);
         FacturaDTO dto = FacturaPersistence.getFactura(entity.getId());
         Assert.assertNotNull(dto);
          Assert.assertEquals(dto.getTotalAPagar(), entity.getTotalAPagar());
          Assert.assertEquals(dto.getFecha(), entity.getFecha());
          
         Assert.assertEquals(entity.getId(), dto.getId());
     }

     @Test
     public void deleteFacturaTest() {
         FacturaEntity entity = data.get(0);
         FacturaPersistence.deleteFactura(entity.getId());
         FacturaEntity deleted = em.find(FacturaEntity.class, entity.getId());
         Assert.assertNull(deleted);
     }
     @Test
     public void updateFacturaTest() {
         FacturaEntity entity = data.get(0);
         // se instancia el generador de datos Podam
       PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
         FacturaDTO dto = factory.manufacturePojo(FacturaDTO.class);
         dto.setId(entity.getId());
         FacturaPersistence.updateFactura(dto);
         FacturaEntity resp = em.find(FacturaEntity.class, entity.getId());
          Assert.assertEquals(dto.getTotalAPagar(), entity.getTotalAPagar());
          Assert.assertEquals(dto.getFecha(), entity.getFecha());
          Assert.assertEquals(dto.getId(), resp.getId());
     }
}