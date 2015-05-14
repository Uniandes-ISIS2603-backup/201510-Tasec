/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.tasec.tasec.web.test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Test;
/**
 *
 * @author JuanPablo
 */
public class TasecTests {
    
 private static WebDriver driver;
    private static String baseUrl;
    private static boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();
 
    /*La anotación ‘@BeforeClass’ indica lo que se debe ejecutar ANTES de correr
     el archivo de pruebas. Este método instancia un nuevo driver firefox
     (causando la apertura de una ventana física de firefox).*/
    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8383/201510-Tasec/index.html#";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    /* La anotación ‘@AfterClass’ indica lo que se debe ejecutar DESPUÉS de ejecutar
     el archivo de pruebas. Este método cierra la ventana de firefox
     abierta por @BeforeClass que se utilizó para la prueba.*/
 
    @AfterClass
    public static void tearDown() throws Exception {
 
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
 
    @Before
    public void setUpTest() {
        driver.get(baseUrl + "/registrarse");
    }
 
    @Test
    public void TestcreateCliente() throws Exception {
        boolean success = false;
        driver.findElement(By.partialLinkText("Soy Cliente")).click();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Registrese")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("cliente.nombre")).clear();
        driver.findElement(By.id("cliente.correo")).clear();
        driver.findElement(By.id("cliente.edad")).clear();
        driver.findElement(By.id("cliente.contrasena1")).clear();
        driver.findElement(By.id("cliente.contrasena2")).clear();
        
        driver.findElement(By.id("cliente.nombre")).sendKeys("Juan Pablo Arevalo");
        driver.findElement(By.id("cliente.correo")).sendKeys("juanpabloaa21@hotmail.com");
        driver.findElement(By.id("cliente.edad")).sendKeys("21");
        driver.findElement(By.id("cliente.contrasena1")).sendKeys("contrasenanum1");
        driver.findElement(By.id("cliente.contrasena2")).sendKeys("contrasenanum1");
        
        driver.findElement(By.id("registrarCForm.$invalid")).click();
        Thread.sleep(2000);
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id,'Table')]/tbody/tr"));
        for (WebElement webElement : rows) {
            List<WebElement> elems = webElement.findElements(By.xpath("td"));
            if (elems.get(0).getText().equals("Juan Pablo Arevalo") && elems.get(1).getText().equals("juanpabloaa21@hotmail.com")&& elems.get(2).getText().equals("21")&& elems.get(3).getText().equals("contrasenanum1")&& elems.get(4).getText().equals("contrasenanum1")) {
                success = true;
            }
        }
        assertTrue(success);
        Thread.sleep(2000);
    }
 
    @Test
    public void TestLoginCliente() throws Exception {
        boolean success = false;
        driver.findElement(By.partialLinkText("Soy Cliente")).click();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Ya eres parte de Tasec?")).click();
        Thread.sleep(3000);
 
        driver.findElement(By.id("cliente.correo")).clear();
        driver.findElement(By.id("cliente.password")).clear();
        driver.findElement(By.id("cliente.correo")).sendKeys("juanpabloaa21@hotmail.com");
        driver.findElement(By.id("cliente.password")).sendKeys("contrasenanum1");
       
        driver.findElement(By.id("loginCliente.$invalid")).click();
        Thread.sleep(2000);
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id,'Table')]/tbody/tr"));
        for (WebElement webElement : rows) {
            List<WebElement> elems = webElement.findElements(By.xpath("td"));
            if (elems.get(0).getText().equals("juanpabloaa21@hotmail.com")&& elems.get(1).getText().equals("contrasenanum1")) {
                success = true;
            }
        }
        assertTrue(success);
        Thread.sleep(2000);
    }
 
    @Test
    public void TestCreateProveedor() throws Exception {
         boolean success = false;
        driver.findElement(By.partialLinkText("Soy un Proveedor de Servicios")).click();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Registrese")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("proveedor.nombre")).clear();
        driver.findElement(By.id("proveedor.correo")).clear();
        driver.findElement(By.id("proveedor.descripcion")).clear();
        driver.findElement(By.id("proveedor.contrasena1")).clear();
        driver.findElement(By.id("proveedor.contrasena2")).clear();
        
        driver.findElement(By.id("proveedor.nombre")).sendKeys("Juan Pablo Arevalo");
        driver.findElement(By.id("proveedor.correo")).sendKeys("juanpabloaa21@hotmail.com");
        driver.findElement(By.id("proveedor.descripcion")).sendKeys("Descripcion1");
        driver.findElement(By.id("proveedor.contrasena1")).sendKeys("contrasenanum1");
        driver.findElement(By.id("proveedor.contrasena2")).sendKeys("contrasenanum1");
        
        driver.findElement(By.id("registrarPForm.$invalid")).click();
        Thread.sleep(2000);
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id,'Table')]/tbody/tr"));
        for (WebElement webElement : rows) {
            List<WebElement> elems = webElement.findElements(By.xpath("td"));
            if (elems.get(0).getText().equals("Juan Pablo Arevalo") && elems.get(1).getText().equals("juanpabloaa21@hotmail.com")&& elems.get(2).getText().equals("Descripcion1")&& elems.get(3).getText().equals("contrasenanum1")&& elems.get(4).getText().equals("contrasenanum1")) {
                success = true;
            }
        }
        assertTrue(success);
        Thread.sleep(2000);
    }
 
    @Test
     @Test
    public void TestLoginProveedor() throws Exception {
        boolean success = false;
         driver.findElement(By.partialLinkText("Soy un Proveedor de Servicios")).click();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Ya tiene un usuario?")).click();
        Thread.sleep(3000);
 
        driver.findElement(By.id("cliente.correo")).clear();
        driver.findElement(By.id("cliente.password")).clear();
        driver.findElement(By.id("cliente.correo")).sendKeys("juanpabloaa21@hotmail.com");
        driver.findElement(By.id("cliente.password")).sendKeys("contrasenanum1");
       
        driver.findElement(By.id("loginProveedor.$invalid")).click();
        Thread.sleep(2000);
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id,'Table')]/tbody/tr"));
        for (WebElement webElement : rows) {
            List<WebElement> elems = webElement.findElements(By.xpath("td"));
            if (elems.get(0).getText().equals("juanpabloaa21@hotmail.com")&& elems.get(1).getText().equals("contrasenanum1")) {
                success = true;
            }
        }
        assertTrue(success);
        Thread.sleep(2000);
    }
}