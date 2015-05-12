/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.test;


import co.edu.uniandes.csw.eTours.service.NoticiaService;
import java.io.File;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;



/**
 *
 * @author estudiante
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Arquillian.class)
public class NoticiaTest {
     private Object MethodSorters;
       public static Archive<?> createDeployment() {
          MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
 
         WebArchive war = ShrinkWrap
                 
                  .create(WebArchive.class, "SportClub.service.war")
                 // Se agrega la dependencia a la lógica con el nombre groupid:artefactid:version (GAV)
                 .addAsLibraries(resolver.artifact("co.edu.uniandes.csw.SportGroup:SportClub.logic:0.0.1")
                         .resolveAsFiles())
                 // Se agregan los compilados de los paquetes de servicios que se van a probar
                 .addPackage(NoticiaService.class.getPackage())        
                 // Se agregan los html, el bootstrap y los javascript.
//                 .addAsWebResource(new File(URLRESOURCES, "index.html"))
//                 .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/").as(GenericArchive.class), "/src/", Filters.includeAll())
                 // El archivo que contiene la configuracion a la base de datos.
                 .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                 // El archivo beans.xml es necesario para injección de dependencias.
                 .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
                 // El archivo web.xml es necesario para el despliegue de los servlets
                 .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));
         return war;
     }

}
