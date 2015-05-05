/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.ejb;

import co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.api.ISolicitudIngresoLogic;
import co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.converter.SolicitudIngresoConverter;
import co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.dto.SolicitudIngresoDTO;
import co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.dto.SolicitudIngresoPageDTO;
import co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.entity.SolicitudIngresoEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author estudiante
 */
@Default
@Stateless
@LocalBean
public class SolicitudIngresoLogic implements ISolicitudIngresoLogic{
    
    @PersistenceContext(unitName = "eToursClassPU")
    protected EntityManager entityManager;

    public SolicitudIngresoDTO createSolicitudIngreso(SolicitudIngresoDTO detail) {
        SolicitudIngresoEntity entity = SolicitudIngresoConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return SolicitudIngresoConverter.entity2PersistenceDTO(entity);
    }

    public SolicitudIngresoDTO getSolicitudIngreso(Long id) {
        return SolicitudIngresoConverter.entity2PersistenceDTO(entityManager.find(SolicitudIngresoEntity.class, id));

    }

    public void deleteSolicitudIngreso(Long id) {
        SolicitudIngresoEntity entity = entityManager.find(SolicitudIngresoEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateSolicitudIngreso(SolicitudIngresoDTO pSolicitud) {
        SolicitudIngresoEntity entity = entityManager.merge(SolicitudIngresoConverter.persistenceDTO2Entity(pSolicitud));
        SolicitudIngresoConverter.entity2PersistenceDTO(entity);
    }

    public SolicitudIngresoDTO updateSolicitudIngreso(Long id, int pNuevoEstado) {
        SolicitudIngresoDTO ingreso = getSolicitudIngreso(id);
        ingreso.setEstado(pNuevoEstado);
        updateSolicitudIngreso(ingreso);
        return ingreso;
    }
    
    public List<SolicitudIngresoDTO> getSolicitudesIngreso() {
        Query q = entityManager.createQuery("select u from SolicitudIngresoEntity u");
        return SolicitudIngresoConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public SolicitudIngresoPageDTO getSolicitudesIngreso(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from SolicitudIngresoEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from SolicitudIngresoEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        SolicitudIngresoPageDTO response = new SolicitudIngresoPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(SolicitudIngresoConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public List<SolicitudIngresoDTO> getSolicitudesIngresoEstado(int pEstado) {
        Query q = entityManager.createQuery("select u from SolicitudIngresoEntity u");
        List<SolicitudIngresoDTO> response = SolicitudIngresoConverter.entity2PersistenceDTOList(q.getResultList());
        for (SolicitudIngresoDTO ingr : response){
            if (ingr.getEstado() != pEstado){
                response.remove(ingr);
            }
        }
        return response;
    }

    public SolicitudIngresoPageDTO getSolicitudesIngresoEstado(int pEstado, Integer page, Integer maxRecords) {
        Query q = entityManager.createQuery("select u from SolicitudIngresoEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        
        List<SolicitudIngresoDTO> ingresos = SolicitudIngresoConverter.entity2PersistenceDTOList(q.getResultList());
        for (SolicitudIngresoDTO ingr : ingresos){
            if (ingr.getEstado() != pEstado){
                ingresos.remove(ingr);
            }
        }
        
        SolicitudIngresoPageDTO response = new SolicitudIngresoPageDTO();
        response.setTotalRecords(Long.parseLong(""+ingresos.size()));
        response.setRecords(ingresos);
        return response;
    }

    public List<SolicitudIngresoDTO> getSolicitudesIngresoFecha(String pFecha) {
        Query q = entityManager.createQuery("select u from SolicitudIngresoEntity u");
        List<SolicitudIngresoDTO> response = SolicitudIngresoConverter.entity2PersistenceDTOList(q.getResultList());
        for (SolicitudIngresoDTO ingr : response){
            if (!ingr.getFecha().equals(pFecha)){
                response.remove(ingr);
            }
        }
        return response;
    }

    public SolicitudIngresoPageDTO getSolicitudesIngresoFecha(String pFecha, Integer page, Integer maxRecords) {
        Query q = entityManager.createQuery("select u from SolicitudIngresoEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        
        List<SolicitudIngresoDTO> ingresos = SolicitudIngresoConverter.entity2PersistenceDTOList(q.getResultList());
        for (SolicitudIngresoDTO ingr : ingresos){
            if (!ingr.getFecha().equals(pFecha)){
                ingresos.remove(ingr);
            }
        }
        
        SolicitudIngresoPageDTO response = new SolicitudIngresoPageDTO();
        response.setTotalRecords(Long.parseLong(""+ingresos.size()));
        response.setRecords(ingresos);
        return response;
    }

    public List<SolicitudIngresoDTO> getSolicitudesIngresoProveedor(Long id_Proveedor) {
        Query q = entityManager.createQuery("select u from SolicitudIngresoEntity u");
        List<SolicitudIngresoDTO> response = SolicitudIngresoConverter.entity2PersistenceDTOList(q.getResultList());
        for (SolicitudIngresoDTO ingr : response){
            if (!ingr.getIdProveedor().equals(id_Proveedor)){
                response.remove(ingr);
            }
        }
        return response;
    }

    public SolicitudIngresoPageDTO getSolicitudesIngresoProveedor(Long id_Proveedor, Integer page, Integer maxRecords) {
        Query q = entityManager.createQuery("select u from SolicitudIngresoEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        
        List<SolicitudIngresoDTO> ingresos = SolicitudIngresoConverter.entity2PersistenceDTOList(q.getResultList());
        for (SolicitudIngresoDTO ingr : ingresos){
            if (!ingr.getIdProveedor().equals(id_Proveedor)){
                ingresos.remove(ingr);
            }
        }
        
        SolicitudIngresoPageDTO response = new SolicitudIngresoPageDTO();
        response.setTotalRecords(Long.parseLong(""+ingresos.size()));
        response.setRecords(ingresos);
        return response;
    }
    
}
