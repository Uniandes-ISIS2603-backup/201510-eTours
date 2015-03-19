/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Evento.logic.converter;

import co.edu.uniandes.csw.eTours.Evento.logic.dto.EventoDTO;
import co.edu.uniandes.csw.eTours.Evento.logic.enity.EventoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class EventoConverter {
    public static EventoDTO entity2PersistenceDTO(EventoEntity entity) {
        if (entity != null) {
            EventoDTO dto = new EventoDTO();
            dto.setId(entity.getId());
            dto.setContacto(entity.getContacto());
            dto.setFin(entity.getFin());
            dto.setIdPublicador(entity.getIdPublicador());
            dto.setInicio(entity.getInicio());
            dto.setLugar(entity.getLugar());
            dto.setOrganizador(entity.getOrganizador());
            dto.setReqInscripcion(entity.getReqInscripcion());
            return dto;
        } else {
            return null;
        }
    }

    public static EventoEntity persistenceDTO2Entity(EventoDTO dto) {
        if (dto != null) {
            EventoEntity entity = new EventoEntity();
            entity.setId(dto.getId());
            entity.setContacto(dto.getContacto());
            entity.setFin(dto.getFin());
            entity.setIdPublicador(dto.getIdPublicador());
            entity.setInicio(dto.getInicio());
            entity.setLugar(dto.getLugar());
            entity.setOrganizador(dto.getOrganizador());
            entity.setReqInscripcion(dto.getReqInscripcion());
            return entity;
        } else {
            return null;
        }
    }

    public static List<EventoDTO> entity2PersistenceDTOList(List<EventoEntity> entities) {
        List<EventoDTO> dtos = new ArrayList<EventoDTO>();
        for (EventoEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<EventoEntity> persistenceDTO2EntityList(List<EventoDTO> dtos) {
        List<EventoEntity> entities = new ArrayList<EventoEntity>();
        for (EventoDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
