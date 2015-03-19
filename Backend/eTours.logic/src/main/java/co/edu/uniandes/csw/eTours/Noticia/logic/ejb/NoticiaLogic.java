/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Noticia.logic.ejb;

import co.edu.uniandes.csw.eTours.Noticia.entity.NoticiaEntity;
import co.edu.uniandes.csw.eTours.Noticia.logic.api.INoticiaLogic;
import co.edu.uniandes.csw.eTours.Noticia.logic.converter.NoticiaConverter;
import co.edu.uniandes.csw.eTours.Noticia.logic.dto.NoticiaDTO;
import co.edu.uniandes.csw.eTours.Noticia.logic.dto.NoticiaPageDTO;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author estudiante
 */
public class NoticiaLogic implements INoticiaLogic{
    @PersistenceContext(unitName = "eToursClassPU")
    protected EntityManager entityManager;

    public NoticiaDTO createNoticia(NoticiaDTO details) {
        NoticiaEntity entity = NoticiaConverter.persistenceDTO2Entity(details);
        entityManager.persist(entity);
        return NoticiaConverter.entity2PersistenceDTO(entity);
    }

    public List<NoticiaDTO> getNoticias() {
        Query q = entityManager.createQuery("select u from PaqueteEntity u");
        return NoticiaConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public NoticiaDTO getNoticiaTitulo(String titulo) {
        return NoticiaConverter.entity2PersistenceDTO(entityManager.find(NoticiaEntity.class, titulo));
    }

    public void deleteNoticia(String titulo) {
        NoticiaEntity entity = entityManager.find(NoticiaEntity.class, titulo);
        entityManager.remove(entity);
    }

    public void updateNoticia(NoticiaDTO details) {
        NoticiaEntity entity = entityManager.merge(NoticiaConverter.persistenceDTO2Entity(details));
        NoticiaConverter.entity2PersistenceDTO(entity);
    }

    public List<NoticiaDTO> getNoticiasFecha(Date fechaInicial) {
        Query q = entityManager.createQuery("select u from NoticiaEntity u where u.fechaInicial="+fechaInicial);
         return NoticiaConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public NoticiaPageDTO getNoticia(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from NoticiaEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from NoticiaEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        NoticiaPageDTO response = new NoticiaPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(NoticiaConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }
    
}
