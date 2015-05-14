/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.web.test;

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
        // Es la instancia inicial del web driver que controlar� el navegador firefox
        private static WebDriver driver;
        // url en el cual se aloja la p�gina web (en este caso localhost:8080)
        private static String baseUrl;
        // variable que indica si varios alert consecutivos (alert javascript) se tomar�n
        private static boolean acceptNextAlert = true;
        private static StringBuffer verificationErrors = new StringBuffer();
 
        @Before
         public void setUpUrl() {
             driver.get(baseUrl + "/noticia.service");
        }
       /*La anotaci�n @BeforeClass indica lo que se debe ejecutar ANTES de correr el archivo de pruebas. Este m�todo instancia un nuevo driver firefox (causando la apertura de una ventana f�sica de firefox).*/
        @BeforeClass
        public static void setUp() throws Exception {
            driver = new FirefoxDriver();
        // se define el url base del proyecto web
            baseUrl = "http://localhost:8080";
        /* Indica cuanto se espera para la respuesta de cualquier comando realizado hacia el navegador*/
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
 
 
        // La anotaci�n @AfterClass indica lo que se debe ejecutar DESPUES de ejecutar
        // el archivo de pruebas. Este m�todo cierra la ventana de firefox
        // abierta por @BeforeClass que se utiliz� para la prueba.
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
         * funci�n 'find' encuentra el control y posteriormente hace clic en el
         * mismo. La forma en la que se busca el control es utilizando
         * expresiones definidas por el web driver y xpath*/
 
        boolean success = false;
        
        driver.findElement(By.partialLinkText("Noticia")).click();
        /**
         * Comando que duerme el Thread del test por 3 segundos para dejar que
         * el efecto 'slide down' abra la pagina de Sport.
         */
 
        Thread.sleep(3000);
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
        
        
        List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@id,'noticiasAgregadas')]"));
        for (WebElement webElement : rows) {
            List<WebElement> elems = webElement.findElements(By.xpath("div/div/div/p"));
            if (elems.get(1).getText().equals("Gran espectaculo")) {
                success = true;
            }
        }
         /**
         * la prueba es exitosa si se encontr�
         * el nuevo elemento creado en la lista.
         */
        
        assertTrue(success);
        Thread.sleep(2000);
    }
    @Test
    public void t1deleteNoticia() throws Exception
    {
        boolean success = false;
        driver.findElement(By.partialLinkText("Noticia")).click();
        Thread.sleep(3000);
        //Busca las noticias ya existentes
        List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@id,'noticiasAgregadas')]"));
        for (WebElement webElement : rows) {
            List<WebElement> elems = webElement.findElements(By.xpath("p"));
            if (elems.get(1).getText().equals("Gran espectaculo")) {
                List<WebElement> buttons = elems.get(7).findElements(By.xpath("button"));
                buttons.get(1).click();
                success = true;
                break;
            }
        }
        Thread.sleep(3000);
        //Se busca el objeto que fue eliminado, si se encuentra hay error al eliminar
        rows = driver.findElements(By.xpath("//div[contains(@id,'noticiasAgregadas')]"));
        if(rows.size()>0){
            for (WebElement webElement : rows) {
                List<WebElement> elems = webElement.findElements(By.xpath("p"));
                if (elems.get(1).getText().equals("Gran espectaculo")) {
                    success = false;
                    break;
                }
            }
        }
 
        Thread.sleep(3000);
        assertTrue(success);
    }
}

