/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioTest;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.converter.MensajeConverter;
import co.edu.uniandes.csw.TASEC.Usuario.logic.api.IUsuarioLogic;
import co.edu.uniandes.csw.TASEC.Usuario.logic.converter.UsuarioConverter;
import co.edu.uniandes.csw.TASEC.Usuario.logic.dto.UsuarioDTO;
import co.edu.uniandes.csw.TASEC.Usuario.logic.ejb.UsuarioLogic;
import co.edu.uniandes.csw.TASEC.Usuario.logic.entity.UsuarioEntity;
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
public class UsuarioTest {
     public static final String DEPLOY = "Prueba";
      @Deployment
      public static JavaArchive createDeployment() {
          return ShrinkWrap.create(JavaArchive.class, DEPLOY + ".jar")
                  //A�ade el paquete en el que se encuentra la clase 'SportPersistance.java'
                  .addPackage(UsuarioLogic.class.getPackage())
                  //A�ade el paquete en el que se encuentra la clase 'SportEntity.java'
                  .addPackage(UsuarioEntity.class.getPackage())
                  //Finalmente se a�aden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete m�nimo
                  .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                  .addAsResource("META-INF/beans.xml", "META-INF/beans.xml");
      }
      @Inject
      private IUsuarioLogic UsuarioPersistence;
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
          em.createQuery("delete from UsuarioEntity").executeUpdate();
      }
      private List<UsuarioEntity> data = new ArrayList<UsuarioEntity>();
      private void insertData() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          //Luego, se generan 10 datos de prueba diferentes
          for (int i = 0; i < 3; i++) {
              UsuarioEntity entity = UsuarioConverter.persistenceDTO2Entity(factory.manufacturePojo(UsuarioDTO.class));
 
              //Persiste el objeto en base de datos
              em.persist(entity);
              //Se a�ade a la lista del or�culo
              data.add(entity);
          }
      }
      @Test
      public void createUsuarioTest() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          UsuarioDTO dto = factory.manufacturePojo(UsuarioDTO.class);
          UsuarioDTO result = UsuarioPersistence.createUsuario(dto);
          Assert.assertNotNull(result);
          UsuarioEntity entity = em.find(UsuarioEntity.class, result.getId());
 
          Assert.assertEquals(dto.getNombre(),entity.getNombre());
          Assert.assertEquals(dto.getId(), entity.getId());
          Assert.assertEquals(dto.getContrasenha(),entity.getContrasenha());
          Assert.assertEquals(dto.getEdad(),entity.getEdad());
          Assert.assertEquals(dto.getLogin(),entity.getLogin());
          Assert.assertEquals(dto.getMensajes(),MensajeConverter.entity2PersistenceDTOList(entity.getMensajes()));
          Assert.assertEquals(dto.getEMail(),entity.getEMail());
      }
      @Test
      public void getUsuarioesTest() {
          List<UsuarioDTO> list = UsuarioPersistence.getUsuarios();
          Assert.assertEquals(list.size(), data.size());
          for (UsuarioDTO dto : list) {
              boolean found = false;
              for (UsuarioEntity entity : data) {
                  if (dto.getId() == entity.getId()) {
                      found = true;
                  }
             }
             Assert.assertTrue(found);
         }
     }
     @Test
     public void getUsuarioTest() {
         UsuarioEntity entity = data.get(0);
         UsuarioDTO dto = UsuarioPersistence.getUsuario(entity.getId());
         Assert.assertNotNull(dto);
         Assert.assertEquals(dto.getNombre(),entity.getNombre());
         Assert.assertEquals(dto.getId(), entity.getId());
         Assert.assertEquals(dto.getContrasenha(),entity.getContrasenha());
         Assert.assertEquals(dto.getEdad(),entity.getEdad());
         Assert.assertEquals(dto.getLogin(),entity.getLogin());
         Assert.assertEquals(dto.getMensajes(),MensajeConverter.entity2PersistenceDTOList(entity.getMensajes()));
         Assert.assertEquals(dto.getEMail(),entity.getEMail());
     }

     @Test
     public void deleteUsuarioTest() {
         UsuarioEntity entity = data.get(0);
         UsuarioPersistence.deleteUsuario(entity.getId());
         UsuarioEntity deleted = em.find(UsuarioEntity.class, entity.getId());
         Assert.assertNull(deleted);
     }
     @Test
     public void updateUsuarioTest() {
         UsuarioEntity entity = data.get(0);
         // se instancia el generador de datos Podam
       PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
         UsuarioDTO dto = factory.manufacturePojo(UsuarioDTO.class);
         dto.setId(entity.getId());
         UsuarioPersistence.updateUsuario(dto);
         UsuarioEntity resp = em.find(UsuarioEntity.class, entity.getId());
         Assert.assertEquals(dto.getNombre(),resp.getNombre());
         Assert.assertEquals(dto.getId(), resp.getId());
         Assert.assertEquals(dto.getContrasenha(),resp.getContrasenha());
         Assert.assertEquals(dto.getEdad(),resp.getEdad());
         Assert.assertEquals(dto.getLogin(),resp.getLogin());
         Assert.assertEquals(dto.getMensajes(),MensajeConverter.entity2PersistenceDTOList(resp.getMensajes()));
         Assert.assertEquals(dto.getEMail(),resp.getEMail());
         
         
         
         
         
     }
 }