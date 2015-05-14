/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InformacionTest;
import co.edu.uniandes.csw.TASEC.Informacion.logic.api.IInformacionLogic;
import co.edu.uniandes.csw.TASEC.Informacion.logic.converter.InformacionConverter;
import co.edu.uniandes.csw.TASEC.Informacion.logic.dto.InformacionDTO;
import co.edu.uniandes.csw.TASEC.Informacion.logic.ejb.InformacionLogic;
import co.edu.uniandes.csw.TASEC.Informacion.logic.entity.InformacionEntity;
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
public class InformacionTest {
    public static final String DEPLOY = "Prueba";
      @Deployment
      public static JavaArchive createDeployment() {
          return ShrinkWrap.create(JavaArchive.class, DEPLOY + ".jar")
                  //Añade el paquete en el que se encuentra la clase 'SportPersistance.java'
                  .addPackage(InformacionLogic.class.getPackage())
                  //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                  .addPackage(InformacionEntity.class.getPackage())
                  //Finalmente se añaden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete mínimo
                  .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                  .addAsResource("META-INF/beans.xml", "META-INF/beans.xml");
      }
      @Inject
      private IInformacionLogic InformacionPersistence;
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
          em.createQuery("delete from InformacionEntity").executeUpdate();
      }
      private List<InformacionEntity> data = new ArrayList<InformacionEntity>();
      private void insertData() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          //Luego, se generan 10 datos de prueba diferentes
          for (int i = 0; i < 3; i++) {
              InformacionEntity entity = InformacionConverter.persistenceDTO2Entity(factory.manufacturePojo(InformacionDTO.class));
 
              //Persiste el objeto en base de datos
              em.persist(entity);
              //Se añade a la lista del oráculo
              data.add(entity);
          }
      }
      @Test
      public void createInformacionTest() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          InformacionDTO dto = factory.manufacturePojo(InformacionDTO.class);
          InformacionDTO result = InformacionPersistence.createInformacion(dto);
          Assert.assertNotNull(result);
          InformacionEntity entity = em.find(InformacionEntity.class, result.getId());
 
          Assert.assertEquals(dto.getId(), entity.getId());
      }
      @Test
      public void getInformacionesTest() {
          List<InformacionDTO> list = InformacionPersistence.getInformaciones();
          Assert.assertEquals(list.size(), data.size());
          for (InformacionDTO dto : list) {
              boolean found = false;
              for (InformacionEntity entity : data) {
                  if (dto.getId() == entity.getId()) {
                      found = true;
                  }
             }
             Assert.assertTrue(found);
         }
     }
     @Test
     public void getInformacionTest() {
         InformacionEntity entity = data.get(0);
         InformacionDTO dto = InformacionPersistence.getInformacion(entity.getId());
         Assert.assertNotNull(dto);
          
         Assert.assertEquals(entity.getId(), dto.getId());
     }

     @Test
     public void deleteInformacionTest() {
         InformacionEntity entity = data.get(0);
         InformacionPersistence.deleteInformacion(entity.getId());
         InformacionEntity deleted = em.find(InformacionEntity.class, entity.getId());
         Assert.assertNull(deleted);
     }
     @Test
     public void updateInformacionTest() {
         InformacionEntity entity = data.get(0);
         // se instancia el generador de datos Podam
       PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
         InformacionDTO dto = factory.manufacturePojo(InformacionDTO.class);
         dto.setId(entity.getId());
         InformacionPersistence.updateInformacion(dto);
         InformacionEntity resp = em.find(InformacionEntity.class, entity.getId());
          Assert.assertEquals(dto.getId(), resp.getId());
     }
}