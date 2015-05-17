package ClienteTest;
import co.edu.uniandes.csw.TASEC.Factura.logic.converter.FacturaConverter;
import co.edu.uniandes.csw.TASEC.Mensaje.logic.converter.MensajeConverter;
import co.edu.uniandes.csw.TASEC.cliente.logic.api.IClienteLogic;
import co.edu.uniandes.csw.TASEC.cliente.logic.converter.ClienteConverter;
import co.edu.uniandes.csw.TASEC.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.TASEC.cliente.logic.ejb.ClienteLogic;
import co.edu.uniandes.csw.TASEC.cliente.logic.entity.ClienteEntity;
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
public class ClienteTest {
     public static final String DEPLOY = "Prueba";
      @Deployment
      public static JavaArchive createDeployment() {
          return ShrinkWrap.create(JavaArchive.class, DEPLOY + ".jar")
                  //A�ade el paquete en el que se encuentra la clase 'SportPersistance.java'
                  .addPackage(ClienteLogic.class.getPackage())
                  //A�ade el paquete en el que se encuentra la clase 'SportEntity.java'
                  .addPackage(ClienteEntity.class.getPackage())
                  //Finalmente se a�aden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete m�nimo
                  .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                  .addAsResource("META-INF/beans.xml", "META-INF/beans.xml");
      }
      @Inject
      private IClienteLogic ClientePersistence;
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
          em.createQuery("delete from ClienteEntity").executeUpdate();
      }
      private List<ClienteEntity> data = new ArrayList<ClienteEntity>();
      private void insertData() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          //Luego, se generan 10 datos de prueba diferentes
          for (int i = 0; i < 3; i++) {
              ClienteEntity entity = ClienteConverter.persistenceDTO2Entity(factory.manufacturePojo(ClienteDTO.class));
 
              //Persiste el objeto en base de datos
              em.persist(entity);
              //Se a�ade a la lista del or�culo
              data.add(entity);
          }
      }
      @Test
      public void createClienteTest() {
          // se instancia el generador de datos Podam
          PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
          ClienteDTO dto = factory.manufacturePojo(ClienteDTO.class);
          ClienteDTO result = ClientePersistence.createCliente(dto);
          Assert.assertNotNull(result);
          ClienteEntity entity = em.find(ClienteEntity.class, result.getId());
 
         Assert.assertEquals(dto.getNombre(),entity.getNombre());
         Assert.assertEquals(dto.getId(), entity.getId());
         Assert.assertEquals(dto.getDireccion(), entity.getDireccion());
         Assert.assertEquals(dto.getSaldo(), entity.getSaldo());
         Assert.assertEquals(dto.getTarjetaDeCredito(), entity.getTarjetaDeCredito());
         Assert.assertEquals(dto.getTelefono(), entity.getTelefono());
         Assert.assertEquals(dto.getComprasRealizadas(), FacturaConverter.entity2PersistenceDTOList(entity.getComprasRealizadas()));
         Assert.assertEquals(dto.getContrasenha(),entity.getContrasenha());
         Assert.assertEquals(dto.getEdad(),entity.getEdad());
         Assert.assertEquals(dto.getLogin(),entity.getLogin());
         Assert.assertEquals(dto.getMensajes(),MensajeConverter.entity2PersistenceDTOList(entity.getMensajes()));
         Assert.assertEquals(dto.getEMail(),entity.getEMail());
      }
      @Test
      public void getClienteesTest() {
          List<ClienteDTO> list = ClientePersistence.getClientes();
          Assert.assertEquals(list.size(), data.size());
          for (ClienteDTO dto : list) {
              boolean found = false;
              for (ClienteEntity entity : data) {
                  if (dto.getId() == entity.getId()) {
                      found = true;
                  }
             }
             Assert.assertTrue(found);
         }
     }
     @Test
     public void getClienteTest() {
         ClienteEntity entity = data.get(0);
         ClienteDTO dto = ClientePersistence.getCliente(entity.getId());
         Assert.assertNotNull(dto);
         Assert.assertEquals(dto.getNombre(),entity.getNombre());
         Assert.assertEquals(dto.getId(), entity.getId());
         Assert.assertEquals(dto.getDireccion(), entity.getDireccion());
         Assert.assertEquals(dto.getSaldo(), entity.getSaldo());
         Assert.assertEquals(dto.getTarjetaDeCredito(), entity.getTarjetaDeCredito());
         Assert.assertEquals(dto.getTelefono(), entity.getTelefono());
         Assert.assertEquals(dto.getComprasRealizadas(), FacturaConverter.entity2PersistenceDTOList(entity.getComprasRealizadas()));
         Assert.assertEquals(dto.getContrasenha(),entity.getContrasenha());
         Assert.assertEquals(dto.getEdad(),entity.getEdad());
         Assert.assertEquals(dto.getLogin(),entity.getLogin());
         Assert.assertEquals(dto.getMensajes(),MensajeConverter.entity2PersistenceDTOList(entity.getMensajes()));
         Assert.assertEquals(dto.getEMail(),entity.getEMail());
     }

     @Test
     public void deleteClienteTest() {
         ClienteEntity entity = data.get(0);
         ClientePersistence.deleteCliente(entity.getId());
         ClienteEntity deleted = em.find(ClienteEntity.class, entity.getId());
         Assert.assertNull(deleted);
     }
     @Test
     public void updateClienteTest() {
         ClienteEntity entity = data.get(0);
         // se instancia el generador de datos Podam
       PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
         ClienteDTO dto = factory.manufacturePojo(ClienteDTO.class);
         dto.setId(entity.getId());
         ClientePersistence.updateCliente(dto);
         ClienteEntity resp = em.find(ClienteEntity.class, entity.getId());
         Assert.assertEquals(dto.getNombre(),resp.getNombre());
         Assert.assertEquals(dto.getId(), resp.getId());
         Assert.assertEquals(dto.getDireccion(), resp.getDireccion());
         Assert.assertEquals(dto.getSaldo(), resp.getSaldo());
         Assert.assertEquals(dto.getTarjetaDeCredito(), resp.getTarjetaDeCredito());
         Assert.assertEquals(dto.getTelefono(), resp.getTelefono());
         Assert.assertEquals(dto.getComprasRealizadas(), FacturaConverter.entity2PersistenceDTOList(resp.getComprasRealizadas()));
         Assert.assertEquals(dto.getContrasenha(),resp.getContrasenha());
         Assert.assertEquals(dto.getEdad(),resp.getEdad());
         Assert.assertEquals(dto.getLogin(),resp.getLogin());
         Assert.assertEquals(dto.getMensajes(),MensajeConverter.entity2PersistenceDTOList(resp.getMensajes()));
         Assert.assertEquals(dto.getEMail(),resp.getEMail());
         
         
         
         
         
     }
 }