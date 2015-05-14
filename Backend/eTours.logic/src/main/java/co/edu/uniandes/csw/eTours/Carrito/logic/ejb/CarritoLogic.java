/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Carrito.logic.ejb;

import co.edu.uniandes.csw.eTours.Carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.csw.eTours.Carrito.logic.converter.CarritoConverter;
import co.edu.uniandes.csw.eTours.Carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.csw.eTours.Carrito.logic.dto.CarritoPageDTO;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author estudiante
 */
@Stateless 
@LocalBean
public class CarritoLogic
{
 @PersistenceContext(unitName = "eToursClassPU")
    protected EntityManager entityManager;

    public CarritoDTO createPaquete(CarritoDTO carrito) {
        CarritoEntity entity = CarritoConverter.persistenceDTO2Entity(carrito);
        entityManager.persist(entity);
        return CarritoConverter.entity2PersistenceDTO(entity);
    }

    public List<CarritoDTO> getPaquetes() 
    {
        Query q = entityManager.createQuery("select u from CarritoEntity u");
        return CarritoConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public CarritoPageDTO getPaquete(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from CarritoEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from CarritoEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        CarritoPageDTO response = new CarritoPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(CarritoConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public CarritoDTO getPaquete(Long id) {
        return CarritoConverter.entity2PersistenceDTO(entityManager.find(CarritoEntity.class, id));
    }

    public void deletePaquete(Long id) {
        CarritoEntity entity = entityManager.find(CarritoEntity.class, id);
        entityManager.remove(entity);
    }

    public void updatePaquete(CarritoDTO carrito) {
        CarritoEntity entity = entityManager.merge(CarritoConverter.persistenceDTO2Entity(carrito));
        CarritoConverter.entity2PersistenceDTO(entity);
    }

    public List<CarritoDTO> getServices() {
        Query query = entityManager.createQuery("select u.services from CarritoEntity u");
         CarritoConverter.entity2PersistenceDTO((CarritoEntity)query.getResultList());
         return null;
    }
}
  
