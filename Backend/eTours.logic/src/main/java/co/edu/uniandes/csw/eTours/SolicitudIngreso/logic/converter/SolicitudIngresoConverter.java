/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.converter;

import co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.dto.SolicitudIngresoDTO;
import co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.entity.SolicitudIngresoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class SolicitudIngresoConverter {
    public static SolicitudIngresoDTO entity2PersistenceDTO(SolicitudIngresoEntity entity) {
        if (entity != null) 
        {
            SolicitudIngresoDTO dto = new SolicitudIngresoDTO();
            dto.setId(entity.getId());
            dto.setFecha(entity.getFechaCreacion());
            dto.setEstado(entity.getEstado());
            dto.setIdProveedor(entity.getIdProveedor());
            return dto;
        } 
        else 
        {
            return null;
        }
    }

    public static SolicitudIngresoEntity persistenceDTO2Entity(SolicitudIngresoDTO dto) {
        if (dto != null) 
        {
            SolicitudIngresoEntity entity = new SolicitudIngresoEntity();
            entity.setId(dto.getId());
            entity.setIdProveedor(dto.getIdProveedor());
            entity.setFechaCreacion(dto.getFecha());
            entity.setEstado(dto.getEstado());

            return entity;
        } 
        else 
        {
            return null;
        }
    }

    public static List<SolicitudIngresoDTO> entity2PersistenceDTOList(List<SolicitudIngresoEntity> entities) {
        List<SolicitudIngresoDTO> dtos = new ArrayList<SolicitudIngresoDTO>();
        for (SolicitudIngresoEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<SolicitudIngresoEntity> persistenceDTO2EntityList(List<SolicitudIngresoDTO> dtos) {
        List<SolicitudIngresoEntity> entities = new ArrayList<SolicitudIngresoEntity>();
        for (SolicitudIngresoDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
