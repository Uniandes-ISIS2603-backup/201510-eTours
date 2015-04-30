/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.eTours.web.test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Test;
 
public class NoticiaTest {
        // Es la instancia inicial del web driver que controlará el navegador firefox
        private static WebDriver driver;
        // url en el cual se aloja la página web (en este caso localhost:8080)
        private static String baseUrl;
        // variable que indica si varios alert consecutivos (alert javascript) se tomarán
        private static boolean acceptNextAlert = true;
        private static StringBuffer verificationErrors = new StringBuffer();
 
        @Before
         public void setUpUrl() {
             driver.get(baseUrl + "/noticia.service");
        }
       /*La anotación @BeforeClass indica lo que se debe ejecutar ANTES de correr el archivo de pruebas. Este método instancia un nuevo driver firefox (causando la apertura de una ventana física de firefox).*/
        @BeforeClass
        public static void setUp() throws Exception {
            driver = new FirefoxDriver();
        // se define el url base del proyecto web
            baseUrl = "http://localhost:8080";
        /* Indica cuanto se espera para la respuesta de cualquier comando realizado hacia el navegador*/
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
 
 
        // La anotación @AfterClass indica lo que se debe ejecutar DESPUES de ejecutar
        // el archivo de pruebas. Este método cierra la ventana de firefox
        // abierta por @BeforeClass que se utilizó para la prueba.
        @AfterClass
        public static void tearDown() throws Exception {
            // Se cierra el navegador.
            driver.quit();
           // Se verifica que se haya cerrado efectivamente el navegador.
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }
        
        @Test
    public void t1createNoticia() throws Exception {
 
        /**
         * Comando que realiza click sobre el link "Country". La
         * función 'find' encuentra el control y posteriormente hace clic en el
         * mismo. La forma en la que se busca el control es utilizando
         * expresiones definidas por el web driver y xpath*/
 
        boolean success = false;
        driver.findElement(By.partialLinkText("agregar")).click();

        /**
         * Comando que duerme el Thread del test por 3 segundos para dejar que
         * el efecto 'slide down' abra la pagina createCountry.
         */
        Thread.sleep(3000);
        
        
        /**
         * Comando que busca el elemento 'titulo' en el html actual. Ver ids en country.tpl.html
         * Posteriormente limpia su contenido (comando clear).
         */
        driver.findElement(By.id("titulo")).clear();
        driver.findElement(By.id("titulo")).sendKeys("Gran espectaculo");
          
        /**
         * Comando que busca el elemento 'entrada' en el html actual. Ver ids en country.tpl.html
         * Posteriormente limpia su contenido (comando clear).
         */
        driver.findElement(By.id("entrada")).clear();
        driver.findElement(By.id("entrada")).sendKeys("Un show que no se puede perder");
        
        /**
         * Comando que busca el elemento 'fechaInic' en el html actual. Ver ids en country.tpl.html
         * Posteriormente limpia su contenido (comando clear).
         */
        driver.findElement(By.id("fechaInic")).clear();
        driver.findElement(By.id("fechaInic")).sendKeys("01/06/2015");
        
        /**
         * Comando que busca el elemento 'fechaFinal' en el html actual. Ver ids en country.tpl.html
         * Posteriormente limpia su contenido (comando clear).
         */
        driver.findElement(By.id("fechaFinal")).clear();
        driver.findElement(By.id("fechaFinal")).sendKeys("11/06/2015");
        
         /**
         * Comando que busca el boton Save y luego hace click
         * Comando que duerme el Thread del test por 2 segundos
         */
        driver.findElement(By.id("save")).click();
        Thread.sleep(2000);
        
        //TODO  Pedir noticias, no hay tabla.
        
         /**
         * la prueba es exitosa si se encontró
         * el nuevo elemento creado en la lista.
         */
        assertTrue(success);
        Thread.sleep(2000);
    }
    @Test
    public void t1deleteNoticia() throws Exception
    {
        
    }
}
