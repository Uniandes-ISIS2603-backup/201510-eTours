/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Carrito.logic.converter;

import co.edu.uniandes.csw.eTours.Carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.csw.eTours.Carrito.logic.entity.CarritoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class CarritoConverter 
{
      public static CarritoDTO entity2PersistenceDTO(CarritoEntity entity) {
        if (entity != null) {
            CarritoDTO dto = new CarritoDTO();
            dto.setId(entity.getId());
            dto.setCantidad(entity.getCantidad());
            dto.setServices(entity.getServices());
            return dto;
        } else {
            return null;
        }
    }

    public static CarritoEntity persistenceDTO2Entity(CarritoDTO dto) {
        if (dto != null) {
            CarritoEntity entity = new CarritoEntity();
            entity.setId(dto.getId());

            entity.setCantidad(dto.getCantidad());

            entity.setServices(dto.getServices());

            return entity;
        } else {
            return null;
        }
    }

    public static List<CarritoDTO> entity2PersistenceDTOList(List<CarritoEntity> entities) {
        List<CarritoDTO> dtos = new ArrayList<CarritoDTO>();
        for (CarritoEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<CarritoEntity> persistenceDTO2EntityList(List<CarritoDTO> dtos) {
        List<CarritoEntity> entities = new ArrayList<CarritoEntity>();
        for (CarritoDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
