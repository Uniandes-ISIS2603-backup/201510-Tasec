package ClienteTest;
import co.edu.uniandes.csw.TASEC.Cliente.logic.ejb.ClienteLogic;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author JuanPablo
 */
public class ClienteTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(ClienteLogic.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
 
    @Test
    public void should_create_greeting() {
       
                
    }
}
