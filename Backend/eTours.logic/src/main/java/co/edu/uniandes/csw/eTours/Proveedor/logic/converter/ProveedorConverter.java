/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.scw.eTours.Proveedor.logic.converter;

import co.edu.uniandes.csw.eTours.Paquete.logic.converter.*;
import co.edu.uniandes.csw.eTours.Paquete.logic.dto.PaqueteDTO;
import co.edu.uniandes.csw.eTours.Paquete.entity.PaqueteEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author afesguerra
 */
public class ProveedorConverter 
{
    public static PaqueteDTO entity2PersistenceDTO(PaqueteEntity entity) {
        if (entity != null) {
            PaqueteDTO dto = new PaqueteDTO();
            dto.setId(entity.getId());
            dto.setDescuento(entity.getDescuento());
            dto.setServices(entity.getServices());
            return dto;
        } else {
            return null;
        }
    }

    public static PaqueteEntity persistenceDTO2Entity(PaqueteDTO dto) {
        if (dto != null) {
            PaqueteEntity entity = new PaqueteEntity();
            entity.setId(dto.getId());

            entity.setDescuento(dto.getDescuento());

            entity.setServices(dto.getServices());

            return entity;
        } else {
            return null;
        }
    }

    public static List<PaqueteDTO> entity2PersistenceDTOList(List<PaqueteEntity> entities) {
        List<PaqueteDTO> dtos = new ArrayList<PaqueteDTO>();
        for (PaqueteEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<PaqueteEntity> persistenceDTO2EntityList(List<PaqueteDTO> dtos) {
        List<PaqueteEntity> entities = new ArrayList<PaqueteEntity>();
        for (PaqueteDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
