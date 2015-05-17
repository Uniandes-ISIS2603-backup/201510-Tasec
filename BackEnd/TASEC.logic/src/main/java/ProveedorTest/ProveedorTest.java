/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProveedorTest;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.converter.MensajeConverter;
import co.edu.uniandes.csw.TASEC.PaqueteServicios.logic.converter.PaqueteServiciosConverter;
import co.edu.uniandes.csw.TASEC.Proveedor.logic.api.IProveedorLogic;
import co.edu.uniandes.csw.TASEC.Proveedor.logic.converter.ProveedorConverter;
import co.edu.uniandes.csw.TASEC.Proveedor.logic.dto.ProveedorDTO;
import co.edu.uniandes.csw.TASEC.Proveedor.logic.ejb.ProveedorLogic;
import co.edu.uniandes.csw.TASEC.Proveedor.logic.entity.ProveedorEntity;
import co.edu.uniandes.csw.TASEC.ServicioSimple.logic.converter.ServicioSimpleConverter;
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
public class ProveedorTest {
    public static final String DEPLOY = "Prueba";
      @Deployment
      public static JavaArchive createDeployment() {
          return ShrinkWrap.create(JavaArchive.class, DEPLOY + ".jar")
                  //A�ade el paquete en el que se encuentra la clase 'SportPersistance.java'
                  .addPackage(ProveedorLogic.class.getPackage())
                  //A�ade el paquete en el que se encuentra la clase 'SportEntity.java'
                  .addPackage(ProveedorEntity.class.getPackage())
                  //Finalmente se a�aden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete m�nimo
                  .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                  .addAsResource("META-INF/beans.xml", "META-INF/beans.xml");
      }
      @Inject
      private IProveedorLogic ProveedorPersistence;
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
          em.createQuery("delete from ProveedorEntity").executeUpdate();
      }
      private List<ProveedorEntity> data = new ArrayList<ProveedorEntity>();
      private void insertData() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          //Luego, se generan 10 datos de prueba diferentes
          for (int i = 0; i < 3; i++) {
              ProveedorEntity entity = ProveedorConverter.persistenceDTO2Entity(factory.manufacturePojo(ProveedorDTO.class));
 
              //Persiste el objeto en base de datos
              em.persist(entity);
              //Se a�ade a la lista del or�culo
              data.add(entity);
          }
      }
      @Test
      public void createProveedorTest() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          ProveedorDTO dto = factory.manufacturePojo(ProveedorDTO.class);
          ProveedorDTO result = ProveedorPersistence.createProveedor(dto);
          Assert.assertNotNull(result);
          ProveedorEntity entity = em.find(ProveedorEntity.class, result.getId());
 
          Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
          Assert.assertEquals(dto.getServicios(), ServicioSimpleConverter.entity2PersistenceDTOList(entity.getServicios()));
          Assert.assertEquals(dto.getPaquetes(), PaqueteServiciosConverter.entity2PersistenceDTOList(entity.getPaquetes()));
          Assert.assertEquals(dto.getVentas(), entity.getVentas());
          Assert.assertEquals(dto.getId(), entity.getId());
          Assert.assertEquals(dto.getContrasenha(),entity.getContrasenha());
          Assert.assertEquals(dto.getEdad(),entity.getEdad());
          Assert.assertEquals(dto.getLogin(),entity.getLogin());
          Assert.assertEquals(dto.getMensajes(),MensajeConverter.entity2PersistenceDTOList(entity.getMensajes()));
          Assert.assertEquals(dto.getEMail(),entity.getEMail());
      }
      @Test
      public void getProveedoresTest() {
          List<ProveedorDTO> list = ProveedorPersistence.getProveedores();
          Assert.assertEquals(list.size(), data.size());
          for (ProveedorDTO dto : list) {
              boolean found = false;
              for (ProveedorEntity entity : data) {
                  if (dto.getId() == entity.getId()) {
                      found = true;
                  }
             }
             Assert.assertTrue(found);
         }
     }
     @Test
     public void getProveedorTest() {
         ProveedorEntity entity = data.get(0);
         ProveedorDTO dto = ProveedorPersistence.getProveedor(entity.getId());
         Assert.assertNotNull(dto);
          Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
          Assert.assertEquals(dto.getServicios(), ServicioSimpleConverter.entity2PersistenceDTOList(entity.getServicios()));
          Assert.assertEquals(dto.getPaquetes(), PaqueteServiciosConverter.entity2PersistenceDTOList(entity.getPaquetes()));
          Assert.assertEquals(dto.getVentas(), entity.getVentas());
          Assert.assertEquals(dto.getNombre(),entity.getNombre());
          Assert.assertEquals(dto.getId(), entity.getId());
          Assert.assertEquals(dto.getContrasenha(),entity.getContrasenha());
          Assert.assertEquals(dto.getEdad(),entity.getEdad());
          Assert.assertEquals(dto.getLogin(),entity.getLogin());
          Assert.assertEquals(dto.getMensajes(),MensajeConverter.entity2PersistenceDTOList(entity.getMensajes()));
          Assert.assertEquals(dto.getEMail(),entity.getEMail());
     }

     @Test
     public void deleteProveedorTest() {
         ProveedorEntity entity = data.get(0);
         ProveedorPersistence.deleteProveedor(entity.getId());
         ProveedorEntity deleted = em.find(ProveedorEntity.class, entity.getId());
         Assert.assertNull(deleted);
     }
     @Test
     public void updateProveedorTest() {
         ProveedorEntity entity = data.get(0);
         // se instancia el generador de datos Podam
       PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
         ProveedorDTO dto = factory.manufacturePojo(ProveedorDTO.class);
         dto.setId(entity.getId());
         ProveedorPersistence.updateProveedor(dto);
         ProveedorEntity resp = em.find(ProveedorEntity.class, entity.getId());
          Assert.assertEquals(dto.getDescripcion(), entity.getDescripcion());
          Assert.assertEquals(dto.getServicios(), ServicioSimpleConverter.entity2PersistenceDTOList(entity.getServicios()));
          Assert.assertEquals(dto.getPaquetes(), PaqueteServiciosConverter.entity2PersistenceDTOList(entity.getPaquetes()));
          Assert.assertEquals(dto.getVentas(), entity.getVentas());
          Assert.assertEquals(dto.getNombre(),resp.getNombre());
          Assert.assertEquals(dto.getId(), resp.getId());
          Assert.assertEquals(dto.getContrasenha(),resp.getContrasenha());
          Assert.assertEquals(dto.getEdad(),resp.getEdad());
          Assert.assertEquals(dto.getLogin(),resp.getLogin());
          Assert.assertEquals(dto.getMensajes(),MensajeConverter.entity2PersistenceDTOList(resp.getMensajes()));
          Assert.assertEquals(dto.getEMail(),resp.getEMail());
     }
}