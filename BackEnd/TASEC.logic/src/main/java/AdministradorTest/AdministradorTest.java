/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministradorTest;
import co.edu.uniandes.csw.TASEC.Administrador.logic.api.IAdministradorLogic;
import co.edu.uniandes.csw.TASEC.Administrador.logic.converter.AdministradorConverter;
import co.edu.uniandes.csw.TASEC.Administrador.logic.dto.AdministradorDTO;
import co.edu.uniandes.csw.TASEC.Administrador.logic.ejb.AdministradorLogic;
import co.edu.uniandes.csw.TASEC.Administrador.logic.entity.AdministradorEntity;
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
public class AdministradorTest {
    
    public static final String DEPLOY = "Prueba";
      @Deployment
      public static JavaArchive createDeployment() {
          return ShrinkWrap.create(JavaArchive.class, DEPLOY + ".jar")
                  //Añade el paquete en el que se encuentra la clase 'SportPersistance.java'
                  .addPackage(AdministradorLogic.class.getPackage())
                  //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                  .addPackage(AdministradorEntity.class.getPackage())
                  //Finalmente se añaden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete mínimo
                  .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                  .addAsResource("META-INF/beans.xml", "META-INF/beans.xml");
      }
      @Inject
      private IAdministradorLogic AdministradorPersistence;
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
          em.createQuery("delete from AdministradorEntity").executeUpdate();
      }
      private List<AdministradorEntity> data = new ArrayList<AdministradorEntity>();
      private void insertData() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          //Luego, se generan 10 datos de prueba diferentes
          for (int i = 0; i < 3; i++) {
              AdministradorEntity entity = AdministradorConverter.persistenceDTO2Entity(factory.manufacturePojo(AdministradorDTO.class));
 
              //Persiste el objeto en base de datos
              em.persist(entity);
              //Se añade a la lista del oráculo
              data.add(entity);
          }
      }
      @Test
      public void createAdministradorTest() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          AdministradorDTO dto = factory.manufacturePojo(AdministradorDTO.class);
          AdministradorDTO result = AdministradorPersistence.createAdministrador(dto);
          Assert.assertNotNull(result);
          AdministradorEntity entity = em.find(AdministradorEntity.class, result.getId());
 
          Assert.assertEquals(dto.getName(), entity.getName());
          Assert.assertEquals(dto.getId(), entity.getId());
      }
      @Test
      public void getAdministradoresTest() {
          List<AdministradorDTO> list = AdministradorPersistence.getAdministrators();
          Assert.assertEquals(list.size(), data.size());
          for (AdministradorDTO dto : list) {
              boolean found = false;
              for (AdministradorEntity entity : data) {
                  if (dto.getId() == entity.getId()) {
                      found = true;
                  }
             }
             Assert.assertTrue(found);
         }
     }
     @Test
     public void getAdministradorTest() {
         AdministradorEntity entity = data.get(0);
         AdministradorDTO dto = AdministradorPersistence.getAdministrator(entity.getId());
         Assert.assertNotNull(dto);
         Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getId(), dto.getId());
     }

     @Test
     public void deleteAdministradorTest() {
         AdministradorEntity entity = data.get(0);
         AdministradorPersistence.deleteAdministrator(entity.getId());
         AdministradorEntity deleted = em.find(AdministradorEntity.class, entity.getId());
         Assert.assertNull(deleted);
     }
     @Test
     public void updateAdministradorTest() {
         AdministradorEntity entity = data.get(0);
         // se instancia el generador de datos Podam
       PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
         AdministradorDTO dto = factory.manufacturePojo(AdministradorDTO.class);
         dto.setId(entity.getId());
         AdministradorPersistence.updateAdministrator(dto);
         AdministradorEntity resp = em.find(AdministradorEntity.class, entity.getId());
         Assert.assertEquals(dto.getName(), resp.getName());
         Assert.assertEquals(dto.getId(), resp.getId());
     }
 }

