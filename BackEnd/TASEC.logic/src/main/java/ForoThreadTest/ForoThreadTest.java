/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForoThreadTest;
import co.edu.uniandes.csw.TASEC.ThreadForo.logic.ejb.ThreadForoLogic;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 *
 * @author JuanPablo
 */
public class ForoThreadTest 
{

@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(ThreadForoLogic.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
 
    @Test
    public void should_create_greeting() {
       
                
    }
    
}
