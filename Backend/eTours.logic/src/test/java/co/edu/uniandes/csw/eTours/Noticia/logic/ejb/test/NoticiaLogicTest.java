///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.edu.uniandes.csw.eTours.Noticia.logic.ejb.test;
//
//import co.edu.uniandes.csw.eTours.Noticia.entity.NoticiaEntity;
//import co.edu.uniandes.csw.eTours.Noticia.logic.api.INoticiaLogic;
//import co.edu.uniandes.csw.eTours.Noticia.logic.converter.NoticiaConverter;
//import co.edu.uniandes.csw.eTours.Noticia.logic.dto.NoticiaDTO;
//import static co.edu.uniandes.csw.eTours.Noticia.logic.ejb.test.TestUtil.generateRandom;
//import java.util.ArrayList;
//import java.util.List;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.UserTransaction;
//import org.glassfish.ejb.deployment.node.EjbBundleNode;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.spec.WebArchive;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// *
// * @author estudiante
// */
//public class NoticiaLogicTest {
//     public static final String DEPLOY = "Prueba";
//
//    @Deployment
//    public static WebArchive createDeployment() {
//        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
//                .addPackage(NoticiaEntity.class.getPackage())
//                .addPackage(NoticiaDTO.class.getPackage())
//                .addPackage(NoticiaConverter.class.getPackage())
//                .addPackage(NoticiaLogicTest.class.getPackage())
//                .addPackage(INoticiaLogic.class.getPackage())
//                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
//                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
//    }
//
//    @Inject
//    private INoticiaLogic noticiaLogic;
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Inject
//    UserTransaction utx;
//
//    @Before
//    public void configTest() {
//        System.out.println("em: " + em);
//        try {
//            utx.begin();
//            clearData();
//            insertData();
//            utx.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            try {
//                utx.rollback();
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//        }
//    }
//
//    private void clearData() {
//        em.createQuery("delete from NoticiaEntity").executeUpdate();
//    }
//
//    private List<NoticiaEntity> data = new ArrayList<NoticiaEntity>();
//
//    private void insertData() {
//        for (int i = 0; i < 3; i++) {
//            NoticiaEntity entity = new NoticiaEntity();
//            entity.setTitulo(generateRandom(String.class));
//            entity.setCuerpo(generateRandom(String.class));
//            entity.setFechaInicial(generateRandom(String.class));
//            entity.setFechaFinal(generateRandom(String.class));
//            em.persist(entity);
//            data.add(entity);
//        }
//    }
//
//    @Test
//    public void createNoticiaTest() {
//        NoticiaDTO dto = new NoticiaDTO();
//        dto.setTitulo(generateRandom(String.class));
//        dto.setCuerpo(generateRandom(String.class));
//        dto.setFechaInicial(generateRandom(String.class));
//        dto.setFechaFinal(generateRandom(String.class));
//
//        NoticiaDTO result = noticiaLogic.createNoticia(dto);
//
//        Assert.assertNotNull(result);
//
//        NoticiaEntity entity = em.find(NoticiaEntity.class, result.getTitulo());
//
//        Assert.assertEquals(dto.getCuerpo(), entity.getCuerpo());
//        Assert.assertEquals(dto.getFechaInicial(), entity.getFechaInicial());
//        Assert.assertEquals(dto.getFechaFinal(), entity.getFechaFinal());
//    }
//
//    @Test
//    public void getNoticiaTest() {
//        List<NoticiaDTO> list = noticiaLogic.getNoticias();
//        Assert.assertEquals(list.size(), data.size());
//        for (NoticiaDTO dto : list) {
//            boolean found = false;
//            for (NoticiaEntity entity : data) {
//                if (dto.getTitulo().equals(entity.getTitulo())) {
//                    found = true;
//                }
//            }
//            Assert.assertTrue(found);
//        }
//    }
//    
//     @Test
//    public void deleteNoticiaTest() {
//        NoticiaEntity entity = data.get(0);
//        noticiaLogic.deleteNoticia(entity.getTitulo());
//        NoticiaEntity deleted = em.find(NoticiaEntity.class, entity.getTitulo());
//        Assert.assertNull(deleted);
//    }
//
//    @Test
//    public void updateNoticiaTest() {
//        NoticiaEntity entity = data.get(0);
//
//        NoticiaDTO dto = new NoticiaDTO();
//        dto.setTitulo(entity.getTitulo());
//        dto.setCuerpo(generateRandom(String.class));
//        dto.setFechaInicial(generateRandom(String.class));
//        dto.setFechaFinal(generateRandom(String.class));
//
//        noticiaLogic.updateNoticia(dto);
//
//        NoticiaEntity resp = em.find(NoticiaEntity.class, entity.getTitulo());
//
//        Assert.assertEquals(dto.getCuerpo(), resp.getCuerpo());
//        Assert.assertEquals(dto.getFechaInicial(), resp.getFechaInicial());
//    }
//}
