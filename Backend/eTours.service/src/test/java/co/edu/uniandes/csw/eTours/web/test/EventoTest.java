///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.edu.uniandes.csw.eTours.web.test;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import org.junit.AfterClass;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
///**
// *
// * @author danielsoto
// */
//public class EventoTest {
//     // Es la instancia inicial del web driver que controlar� el navegador firefox
//        private static WebDriver driver;
//        // url en el cual se aloja la p�gina web (en este caso localhost:8080)
//        private static String baseUrl;
//        // variable que indica si varios alert consecutivos (alert javascript) se tomar�n
//        private static boolean acceptNextAlert = true;
//        private static StringBuffer verificationErrors = new StringBuffer();
// 
//        @Before
//         public void setUpUrl() {
//             driver.get(baseUrl + "/eTours.service/pages/eventos.html");
//        }
//       /*La anotaci�n @BeforeClass indica lo que se debe ejecutar ANTES de correr el archivo de pruebas. Este m�todo instancia un nuevo driver firefox (causando la apertura de una ventana f�sica de firefox).*/
//        @BeforeClass
//        public static void setUp() throws Exception {
//            driver = new FirefoxDriver();
//        // se define el url base del proyecto web
//            baseUrl = "http://localhost:8080";
//        /* Indica cuanto se espera para la respuesta de cualquier comando realizado hacia el navegador*/
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        }
// 
// 
//        // La anotaci�n @AfterClass indica lo que se debe ejecutar DESPUES de ejecutar
//        // el archivo de pruebas. Este m�todo cierra la ventana de firefox
//        // abierta por @BeforeClass que se utiliz� para la prueba.
//        @AfterClass
//        public static void tearDown() throws Exception {
//            // Se cierra el navegador.
//            driver.quit();
//           // Se verifica que se haya cerrado efectivamente el navegador.
//            String verificationErrorString = verificationErrors.toString();
//            if (!"".equals(verificationErrorString)) {
//                fail(verificationErrorString);
//            }
//        }
//        
//    @Test
//    public void t1createEvento() throws Exception {
// 
//        /**
//         * Comando que realiza click sobre el link "Country". La
//         * funci�n 'find' encuentra el control y posteriormente hace clic en el
//         * mismo. La forma en la que se busca el control es utilizando
//         * expresiones definidas por el web driver y xpath*/
// 
//        boolean success = false;
//        
//        driver.findElement(By.partialLinkText("Crear Evento")).click();
//        /**
//         * Comando que duerme el Thread del test por 3 segundos para dejar que
//         * el efecto 'slide down' abra la pagina de Sport.
//         */
// 
////        Thread.sleep(3000);
////        driver.findElement(By.partialLinkText("agregar")).click();
//
//        /**
//         * Comando que duerme el Thread del test por 3 segundos para dejar que
//         * el efecto 'slide down' abra la pagina createCountry.
//         */
//        Thread.sleep(3000);
//        
//        
//        /**
//         * Comando que busca el elemento 'name' en el html actual. 
//         */
//        driver.findElement(By.id("name")).clear();
//        driver.findElement(By.id("name")).sendKeys("Evento test");
//          
//        /**
//         * Comando que busca el elemento 'hora' en el html actual. 
//         */
//        driver.findElement(By.id("hora")).clear();
//        driver.findElement(By.id("hora")).sendKeys("10:30 am");
//        
//        /**
//         * Comando que busca el elemento 'contenido' en el html actual. 
//         */
//        driver.findElement(By.id("contenido")).clear();
//        driver.findElement(By.id("contenido")).sendKeys("Un evento de prueba para Selenium, sonrie :)");
//        
//        
//         /**
//         * Comando que busca el boton Save y luego hace click
//         * Comando que duerme el Thread del test por 2 segundos
//         */
//        driver.findElement(By.partialLinkText("Guardar")).click();
//        Thread.sleep(2000);
//        
//        
//        List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@id,'eventoD')]"));
//        for (WebElement webElement : rows) {
//            List<WebElement> elems = webElement.findElements(By.xpath("div/p"));
//            if (elems.get(0).getText().equals("Un evento de prueba para Selenium, sonrie :)")) {
//                success = true;
//            }
//        }
//         /**
//         * la prueba es exitosa si se encontr�
//         * el nuevo elemento creado en la lista.
//         */
//        
//        assertTrue(success);
//        Thread.sleep(2000);
//    }
//    @Test
//    public void t1deleteEvento() throws Exception
//    {
//        boolean success = false;
//        //Busca las noticias ya existentes
//        List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@id,'eventoD')]"));
//        for (WebElement webElement : rows) {
//            List<WebElement> elems = webElement.findElements(By.xpath("div/p"));
//            if (elems.get(1).getText().equals("Un evento de prueba para Selenium, sonrie :)")) {
//                List<WebElement> buttons = webElement.findElements(By.xpath("div/ul/li"));
//                buttons.get(1).click();
//                success = true;
//                break;
//            }
//        }
//        Thread.sleep(3000);
//        //Se busca el objeto que fue eliminado, si se encuentra hay error al eliminar
//        rows = driver.findElements(By.xpath("//div[contains(@id,'noticiasAgregadas')]"));
//        if(rows.size()>0){
//          for (WebElement webElement : rows) {
//            List<WebElement> elems = webElement.findElements(By.xpath("div/p"));
//            if (elems.get(1).getText().equals("Un evento de prueba para Selenium, sonrie :)")) {
//                success = false;
//                break;
//            }
//          }
//        }
// 
//        Thread.sleep(3000);
//        assertTrue(success);
//    }
//}
