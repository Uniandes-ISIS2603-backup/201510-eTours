/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.csw.SportGroup.web.test;
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
//import org.junit.runners.MethodSorters;
//import org.junit.FixMethodOrder;
import org.junit.Test;
 
public class SportClubTest {
        // Es la instancia inicial del web driver que controlará el navegador firefox
        private static WebDriver driver;
        // url en el cual se aloja la página web (en este caso localhost:8080)
        private static String baseUrl;
        // variable que indica si varios alert consecutivos (alert javascript) se tomarán
        private static boolean acceptNextAlert = true;
        private static StringBuffer verificationErrors = new StringBuffer();
 
        @Before
        public void setUpUrl() {
            driver.get(baseUrl + "/SportClub.service");
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
    public void t1createCountry() throws Exception {
 
        /**
         * Comando que realiza click sobre el link "Country". La
         * función 'find' encuentra el control y posteriormente hace clic en el
         * mismo. La forma en la que se busca el control es utilizando
         * expresiones definidas por el web driver y xpath*/
 
        boolean success = false;
        driver.findElement(By.partialLinkText("Country")).click();
 
 
        /**
         * Comando que duerme el Thread del test por 3 segundos para dejar que
         * el efecto 'slide down' abra la pagina createCountry.
         */
        Thread.sleep(3000);
        /**
         * Comando que encuentra el botón Create y hace click
         * Comando que duerme el Thread del test por 1 segundo
         */
        driver.findElement(By.id("Create")).click();
        Thread.sleep(1000);
 
 
        /**
         * Comando que busca el elemento 'name1' en el html actual. Ver ids en country.tpl.html
         * Posteriormente limpia su contenido (comando clear).
         */
        driver.findElement(By.id("name1")).clear();
        /**
         * Comando que simula la escritura de un valor en el elemento(sendKeys)
         * con el String de parámetro sobre // el elemento encontrado.
         */
        driver.findElement(By.id("name1")).sendKeys("Colombia");
 
         /**
         * Comando que busca el elemento 'poputation' en el html actual. Ver ids en country.tpl.html
         * Posteriormente limpia su contenido (comando clear).
         */
        driver.findElement(By.id("population")).clear();
        /**
         * Comando que simula la escritura de un valor en el elemento(sendKeys)
         * con el String de parámetro sobre // el elemento encontrado.
         */
        driver.findElement(By.id("population")).sendKeys("80000000");
        /**
         * Comando que busca el boton Save y luego hace click
         * Comando que duerme el Thread del test por 2 segundos
         */
        driver.findElement(By.id("Save")).click();
        Thread.sleep(2000);
 
 
 
         /** Comando que obtiene todos los elementos de la tabla
           * Se realiza la verificación si el elemento creado está en la lista
         */
        List<WebElement> rows =driver.findElements(By.xpath("//table[contains(@id,'Table')]/tbody/tr"));
        for (WebElement webElement : rows) {
            List<WebElement> elems = webElement.findElements(By.xpath("td"));
            if (elems.get(0).getText().equals("Colombia") && elems.get(1).getText().equals("80000000")) {
                /**
                 * si se encuentra la fila, la variable 'success' pasa a true,
                 * indicando que el elemento creado esta en la lista.
                 */
                success = true;
            }
        }
 
        /**
         * la prueba es exitosa si se encontró
         * el nuevo elemento creado en la lista.
         */
        assertTrue(success);
        Thread.sleep(2000);
    }
    
    @Test
    public void t2createSport() throws Exception {
        /**
         * Comando que realiza click sobre el link "Sport". La
         * función 'find' encuentra el control y posteriormente hace clic en el
         * mismo. La forma en la que se busca el control es utilizando
         * expresiones definidas por el web driver y xpath*/
        boolean success = false;
        driver.findElement(By.partialLinkText("Sport")).click();
        /**
         * Comando que duerme el Thread del test por 3 segundos para dejar que
         * el efecto 'slide down' abra la pagina de Sport.
         */
 
        Thread.sleep(3000);
        /**
         * Comando que encuentra el botón Create y hace click
         * Comando que duerme el Thread del test por 3 segundos
         */
 
        driver.findElement(By.id("Create")).click();
        Thread.sleep(3000);
        /**
         * Comando que busca el elemento 'name1' en el html actual. Ver ids en country.tpl.html
         * Posteriormente limpia su contenido (comando clear) y envía Futbol. De igual manera con minAge, maxAge y rules.
         */
        driver.findElement(By.id("name1")).clear();
        driver.findElement(By.id("name1")).sendKeys("Futbol");
        driver.findElement(By.id("minAge")).clear();
        driver.findElement(By.id("minAge")).sendKeys("3");
        driver.findElement(By.id("maxAge")).clear();
        driver.findElement(By.id("maxAge")).sendKeys("90");
        driver.findElement(By.id("rules")).clear();
        driver.findElement(By.id("rules")).sendKeys("No rules");
        /**
         * Comando que busca el elemento select con el id asociado "country"
         * Posteriormente selecciona el pais creado anteriormente "Colombia"
         */
        Select contries = new Select(driver.findElement(By.id("country")));
        contries.selectByVisibleText("Colombia");
        /**
         * Comando que busca el boton Save y luego hace click
         * Comando que duerme el Thread del test por 2 segundos
         */
        driver.findElement(By.id("Save")).click();
        Thread.sleep(2000);
         /** Comando que obtiene todos los elementos de la tabla
           * Se realiza la verificación si el elemento creado está en la lista, buscando por el nombre del sport y el pais asociado
         */
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id,'Table')]/tbody/tr"));
        for (WebElement webElement : rows) {
            List<WebElement> elems = webElement.findElements(By.xpath("td"));
            if (elems.get(0).getText().equals("Futbol") && elems.get(5).getText().equals("Colombia")) {
            /**
                 * si se encuentra la fila, la variable 'success' pasa a true,
                 * indicando que el elemento creado esta en la lista.
                 */
                success = true;
            }
        }
        assertTrue(success);
        Thread.sleep(2000);
    }
}
