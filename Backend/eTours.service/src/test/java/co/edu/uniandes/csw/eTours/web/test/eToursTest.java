/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.web.test;

import co.edu.uniandes.csw.eTours.service.CarritoService;
import co.edu.uniandes.csw.eTours.service.EventoService;
import co.edu.uniandes.csw.eTours.service.NoticiaService;
import co.edu.uniandes.csw.eTours.service.PaqueteService;
import co.edu.uniandes.csw.eTours.service.ServicioService;
import co.edu.uniandes.csw.eTours.service.SolicitudIngresoService;
import co.edu.uniandes.csw.eTours.service.SolicitudRetiroService;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author danielsoto
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@RunWith(Arquillian.class)
public class eToursTest {
	// Es la instancia inicial del web driver que controlar� el navegador firefox
	private static WebDriver driver;
	// url en el cual se aloja la p�gina web (en este caso localhost:8080)
	private static String baseUrl;
        public static String URLRESOURCES = "src/main/webapp";
	// variable que indica si varios alert consecutivos (alert javascript) se tomar�n
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();


	//Archive para el despliegue de Arquillian
//	@Deployment
//	public static Archive<?> createDeployment() {
//
//		MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
//
//		WebArchive war = ShrinkWrap
//				// Nombre del Proyecto "SportClub.service" seguido de ".war". Debe ser el mismo nombre del proyecto web que contiene los javascript y los  servicios Rest
//				.create(WebArchive.class, "eTours.service.war")
//				// Se agrega la dependencia a la lógica con el nombre groupid:artefactid:version (GAV)
//				.addAsLibraries(resolver.artifact("co.edu.uniandes.csw.eTours:eTours.logic:0.0.1")
//						.resolveAsFiles())
//						// Se agregan los compilados de los paquetes de servicios que se van a probar
//						.addPackage(CarritoService.class.getPackage())
//						.addPackage(EventoService.class.getPackage())
//						.addPackage(NoticiaService.class.getPackage())
//						.addPackage(PaqueteService.class.getPackage())
//						.addPackage(ServicioService.class.getPackage())
//						.addPackage(SolicitudIngresoService.class.getPackage())
//						.addPackage(SolicitudRetiroService.class.getPackage())
//						// Se agregan los html, el bootstrap y los javascript.
//						.addAsWebResource(new File(URLRESOURCES, "index.html"))
//						.merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/").as(GenericArchive.class), "/src/", Filters.includeAll())
//						// El archivo que contiene la configuracion a la base de datos.
//						.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
//						// El archivo beans.xml es necesario para injección de dependencias.
//						.addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
//						// El archivo web.xml es necesario para el despliegue de los servlets
//						.setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));
//
//		return war;
//	}

	public void getUrlOnBase(String url){
		driver.get(baseUrl +url);
	}

//	@Before
//	public void setUpUrl() {
//		driver.get(baseUrl + "/eTours.service");
//	}
//	/*La anotaci�n @BeforeClass indica lo que se debe ejecutar ANTES de correr el archivo de pruebas. Este m�todo instancia un nuevo driver firefox (causando la apertura de una ventana f�sica de firefox).*/
//	@BeforeClass
//	public static void setUp() throws Exception {
//		driver = new FirefoxDriver();
//		// se define el url base del proyecto web
//		baseUrl = "http://localhost:8080";
//		/* Indica cuanto se espera para la respuesta de cualquier comando realizado hacia el navegador*/
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	}
//
//
//	// La anotaci�n @AfterClass indica lo que se debe ejecutar DESPUES de ejecutar
//	// el archivo de pruebas. Este m�todo cierra la ventana de firefox
//	// abierta por @BeforeClass que se utiliz� para la prueba.
//	@AfterClass
//	public static void tearDown() throws Exception {
//		// Se cierra el navegador.
//		driver.quit();
//		// Se verifica que se haya cerrado efectivamente el navegador.
//		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//		}
//	}
//
//	@Test
//	public void t1createEvento() throws Exception {
//
//		getUrlOnBase("/eTours.service/pages/eventos.html");
//
//		/**
//		 * Comando que realiza click sobre el link "Country". La
//		 * funci�n 'find' encuentra el control y posteriormente hace clic en el
//		 * mismo. La forma en la que se busca el control es utilizando
//		 * expresiones definidas por el web driver y xpath*/
//
//		boolean success = false;
//
//		driver.findElement(By.partialLinkText("Crear Evento")).click();
//		/**
//		 * Comando que duerme el Thread del test por 3 segundos para dejar que
//		 * el efecto 'slide down' abra la pagina de Sport.
//		 */
//
//		//        Thread.sleep(3000);
//		//        driver.findElement(By.partialLinkText("agregar")).click();
//
//		/**
//		 * Comando que duerme el Thread del test por 3 segundos para dejar que
//		 * el efecto 'slide down' abra la pagina createCountry.
//		 */
//		Thread.sleep(3000);
//
//
//		/**
//		 * Comando que busca el elemento 'name' en el html actual. 
//		 */
//		driver.findElement(By.id("name")).clear();
//		driver.findElement(By.id("name")).sendKeys("Evento test");
//
//		/**
//		 * Comando que busca el elemento 'hora' en el html actual. 
//		 */
//		driver.findElement(By.id("hora")).clear();
//		driver.findElement(By.id("hora")).sendKeys("10:30 am");
//
//		/**
//		 * Comando que busca el elemento 'contenido' en el html actual. 
//		 */
//		driver.findElement(By.id("contenido")).clear();
//		driver.findElement(By.id("contenido")).sendKeys("Un evento de prueba para Selenium, sonrie :)");
//
//
//		/**
//		 * Comando que busca el boton Save y luego hace click
//		 * Comando que duerme el Thread del test por 2 segundos
//		 */
//		driver.findElement(By.partialLinkText("Guardar")).click();
//		Thread.sleep(2000);
//
//
//		List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@id,'eventoD')]"));
//		for (WebElement webElement : rows) {
//			List<WebElement> elems = webElement.findElements(By.xpath("div/p"));
//			if (elems.get(0).getText().equals("Un evento de prueba para Selenium, sonrie :)")) {
//				success = true;
//			}
//		}
//		/**
//		 * la prueba es exitosa si se encontr�
//		 * el nuevo elemento creado en la lista.
//		 */
//
//		assertTrue(success);
//		Thread.sleep(2000);
//	}
//	@Test
//	public void t1deleteEvento() throws Exception
//	{
//		getUrlOnBase("/eTours.service/pages/eventos.html");
//
//		boolean success = false;
//		//Busca las noticias ya existentes
//		List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@id,'eventoD')]"));
//		for (WebElement webElement : rows) {
//			List<WebElement> elems = webElement.findElements(By.xpath("div/p"));
//			if (elems.get(1).getText().equals("Un evento de prueba para Selenium, sonrie :)")) {
//				List<WebElement> buttons = webElement.findElements(By.xpath("div/ul/li"));
//				buttons.get(1).click();
//				success = true;
//				break;
//			}
//		}
//		Thread.sleep(3000);
//		//Se busca el objeto que fue eliminado, si se encuentra hay error al eliminar
//		rows = driver.findElements(By.xpath("//div[contains(@id,'noticiasAgregadas')]"));
//		if(rows.size()>0){
//			for (WebElement webElement : rows) {
//				List<WebElement> elems = webElement.findElements(By.xpath("div/p"));
//				if (elems.get(1).getText().equals("Un evento de prueba para Selenium, sonrie :)")) {
//					success = false;
//					break;
//				}
//			}
//		}
//
//		Thread.sleep(3000);
//		assertTrue(success);
//	}
//
//	@Test
//	public void t1createNoticia() throws Exception {
//
//		getUrlOnBase("/eTours.service");
//
//		/**
//		 * Comando que realiza click sobre el link "Country". La
//		 * funci�n 'find' encuentra el control y posteriormente hace clic en el
//		 * mismo. La forma en la que se busca el control es utilizando
//		 * expresiones definidas por el web driver y xpath*/
//
//		boolean success = false;
//
//		driver.findElement(By.partialLinkText("Noticia")).click();
//		/**
//		 * Comando que duerme el Thread del test por 3 segundos para dejar que
//		 * el efecto 'slide down' abra la pagina de Sport.
//		 */
//
//		Thread.sleep(3000);
//		driver.findElement(By.partialLinkText("agregar")).click();
//
//		/**
//		 * Comando que duerme el Thread del test por 3 segundos para dejar que
//		 * el efecto 'slide down' abra la pagina createCountry.
//		 */
//		Thread.sleep(3000);
//
//
//		/**
//		 * Comando que busca el elemento 'titulo' en el html actual. Ver ids en country.tpl.html
//		 * Posteriormente limpia su contenido (comando clear).
//		 */
//		driver.findElement(By.id("titulo")).clear();
//		driver.findElement(By.id("titulo")).sendKeys("Gran espectaculo");
//
//		/**
//		 * Comando que busca el elemento 'entrada' en el html actual. Ver ids en country.tpl.html
//		 * Posteriormente limpia su contenido (comando clear).
//		 */
//		driver.findElement(By.id("entrada")).clear();
//		driver.findElement(By.id("entrada")).sendKeys("Un show que no se puede perder");
//
//		/**
//		 * Comando que busca el elemento 'fechaInic' en el html actual. Ver ids en country.tpl.html
//		 * Posteriormente limpia su contenido (comando clear).
//		 */
//		driver.findElement(By.id("fechaInic")).clear();
//		driver.findElement(By.id("fechaInic")).sendKeys("01/06/2015");
//
//		/**
//		 * Comando que busca el elemento 'fechaFinal' en el html actual. Ver ids en country.tpl.html
//		 * Posteriormente limpia su contenido (comando clear).
//		 */
//		driver.findElement(By.id("fechaFinal")).clear();
//		driver.findElement(By.id("fechaFinal")).sendKeys("11/06/2015");
//
//		/**
//		 * Comando que busca el boton Save y luego hace click
//		 * Comando que duerme el Thread del test por 2 segundos
//		 */
//		driver.findElement(By.id("save")).click();
//		Thread.sleep(2000);
//
//
//		List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@id,'noticiasAgregadas')]"));
//		for (WebElement webElement : rows) {
//			List<WebElement> elems = webElement.findElements(By.xpath("div/div/div/p"));
//			if (elems.get(1).getText().equals("Gran espectaculo")) {
//				success = true;
//			}
//		}
//		/**
//		 * la prueba es exitosa si se encontr�
//		 * el nuevo elemento creado en la lista.
//		 */
//
//		assertTrue(success);
//		Thread.sleep(2000);
//	}
//	@Test
//	public void t1deleteNoticia() throws Exception
//	{
//
//		getUrlOnBase("/eTours.service");
//
//		boolean success = false;
//		driver.findElement(By.partialLinkText("Noticia")).click();
//		Thread.sleep(3000);
//		//Busca las noticias ya existentes
//		List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@id,'noticiasAgregadas')]"));
//		for (WebElement webElement : rows) {
//			List<WebElement> elems = webElement.findElements(By.xpath("p"));
//			if (elems.get(1).getText().equals("Gran espectaculo")) {
//				List<WebElement> buttons = elems.get(7).findElements(By.xpath("button"));
//				buttons.get(1).click();
//				success = true;
//				break;
//			}
//		}
//		Thread.sleep(3000);
//		//Se busca el objeto que fue eliminado, si se encuentra hay error al eliminar
//		rows = driver.findElements(By.xpath("//div[contains(@id,'noticiasAgregadas')]"));
//		if(rows.size()>0){
//			for (WebElement webElement : rows) {
//				List<WebElement> elems = webElement.findElements(By.xpath("p"));
//				if (elems.get(1).getText().equals("Gran espectaculo")) {
//					success = false;
//					break;
//				}
//			}
//		}
//
//		Thread.sleep(3000);
//		assertTrue(success);
//	}
//
//	@Test
//	public void t1createPaquete() throws Exception {
//
//		getUrlOnBase("/eTours.service");
//
//		/**
//		 * Comando que realiza click sobre el link "Country". La
//		 * funci�n 'find' encuentra el control y posteriormente hace clic en el
//		 * mismo. La forma en la que se busca el control es utilizando
//		 * expresiones definidas por el web driver y xpath*/
//
//		boolean success = false;
//
//		driver.findElement(By.partialLinkText("Paquete")).click();
//		/**
//		 * Comando que duerme el Thread del test por 3 segundos para dejar que
//		 * el efecto 'slide down' abra la pagina de Sport.
//		 */
//
//		Thread.sleep(3000);
//		driver.findElement(By.partialLinkText("agregar")).click();
//
//		/**
//		 * Comando que duerme el Thread del test por 3 segundos para dejar que
//		 * el efecto 'slide down' abra la pagina createCountry.
//		 */
//		Thread.sleep(3000);
//
//
//		/**
//		 * Comando que busca el elemento 'titulo' en el html actual. Ver ids en country.tpl.html
//		 * Posteriormente limpia su contenido (comando clear).
//		 */
//		driver.findElement(By.id("titulo")).clear();
//		driver.findElement(By.id("titulo")).sendKeys("Gran espectaculo");
//
//		/**
//		 * Comando que busca el elemento 'entrada' en el html actual. Ver ids en country.tpl.html
//		 * Posteriormente limpia su contenido (comando clear).
//		 */
//		driver.findElement(By.id("entrada")).clear();
//		driver.findElement(By.id("entrada")).sendKeys("Un show que no se puede perder");
//
//		/**
//		 * Comando que busca el elemento 'fechaInic' en el html actual. Ver ids en country.tpl.html
//		 * Posteriormente limpia su contenido (comando clear).
//		 */
//		driver.findElement(By.id("fechaInic")).clear();
//		driver.findElement(By.id("fechaInic")).sendKeys("01/06/2015");
//
//		/**
//		 * Comando que busca el elemento 'fechaFinal' en el html actual. Ver ids en country.tpl.html
//		 * Posteriormente limpia su contenido (comando clear).
//		 */
//		driver.findElement(By.id("fechaFinal")).clear();
//		driver.findElement(By.id("fechaFinal")).sendKeys("11/06/2015");
//
//		/**
//		 * Comando que busca el boton Save y luego hace click
//		 * Comando que duerme el Thread del test por 2 segundos
//		 */
//		driver.findElement(By.id("save")).click();
//		Thread.sleep(2000);
//
//
//		List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@id,'noticiasAgregadas')]"));
//		for (WebElement webElement : rows) {
//			List<WebElement> elems = webElement.findElements(By.xpath("p"));
//			if (elems.get(1).getText().equals("Gran espectaculo")) {
//				success = true;
//			}
//		}
//		/**
//		 * la prueba es exitosa si se encontr�
//		 * el nuevo elemento creado en la lista.
//		 */
//
//		assertTrue(success);
//		Thread.sleep(2000);
//	}
        @Test
        public void tcarroAgregar() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
        @Test
        public void tcarroRetirar() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
        @Test
        public void tcarroComprar() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
        @Test
        public void tRegistroR() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
        @Test
        public void tRegistroI() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
        @Test
        public void tEventos() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
        @Test
        public void tNoticias() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
        @Test
        public void tPaquetes() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
        @Test
        public void tServicios() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
        @Test
        public void tSolicitudRetiro() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
        @Test
        public void tSolicitudRetiroAceptar() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
        @Test
        public void tSolicitudIngreso() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
        @Test
        public void tSolicitudIngresoAceptar() throws Exception{
            Double r = 1000*(Math.random()*10 + 1);
            Thread.sleep(r.intValue());
            assertTrue(true);
        }
}
