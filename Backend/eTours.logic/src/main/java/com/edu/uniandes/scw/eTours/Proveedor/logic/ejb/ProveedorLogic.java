package com.edu.uniandes.scw.eTours.Proveedor.logic.ejb;

import co.edu.uniandes.csw.eTours.Paquete.logic.ejb.*;
import co.edu.uniandes.csw.eTours.Paquete.logic.api.IPaqueteLogic;
import co.edu.uniandes.csw.eTours.Paquete.logic.converter.PaqueteConverter;
import co.edu.uniandes.csw.eTours.Paquete.logic.dto.PaqueteDTO;
import co.edu.uniandes.csw.eTours.Paquete.logic.dto.PaquetePageDTO;
import co.edu.uniandes.csw.eTours.Paquete.entity.PaqueteEntity;
import com.edu.uniandes.scw.eTours.Proveedor.logic.api.IProveedorLogic;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ProveedorLogic implements IProveedorLogic{

    @PersistenceContext(unitName = "eToursClassPU")
    protected EntityManager entityManager;

    public PaqueteDTO createPaquete(PaqueteDTO paquete) {
        PaqueteEntity entity = PaqueteConverter.persistenceDTO2Entity(paquete);
        entityManager.persist(entity);
        return PaqueteConverter.entity2PersistenceDTO(entity);
    }

    public List<PaqueteDTO> getPaquetes() 
    {
        Query q = entityManager.createQuery("select u from PaqueteEntity u");
        return PaqueteConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public PaquetePageDTO getPaquete(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from PaqueteEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from PaqueteEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        PaquetePageDTO response = new PaquetePageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(PaqueteConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public PaqueteDTO getPaquete(Long id) {
        return PaqueteConverter.entity2PersistenceDTO(entityManager.find(PaqueteEntity.class, id));
    }

    public void deletePaquete(Long id) {
        PaqueteEntity entity = entityManager.find(PaqueteEntity.class, id);
        entityManager.remove(entity);
    }

    public void updatePaquete(PaqueteDTO pauqete) {
        PaqueteEntity entity = entityManager.merge(PaqueteConverter.persistenceDTO2Entity(pauqete));
        PaqueteConverter.entity2PersistenceDTO(entity);
    }

    public List<PaqueteDTO> getServices() {
        Query query = entityManager.createQuery("select u.servicios from PaqueteEntity u");
         PaqueteConverter.entity2PersistenceDTO((PaqueteEntity)query.getResultList());
         return null;
    }

  
}
