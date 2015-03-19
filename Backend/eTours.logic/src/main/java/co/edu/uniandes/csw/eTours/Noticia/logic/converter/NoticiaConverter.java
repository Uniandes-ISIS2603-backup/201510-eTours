/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Noticia.logic.converter;

import co.edu.uniandes.csw.eTours.Noticia.entity.NoticiaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class NoticiaConverter {
    public static NoticiaDTO entity2PersistenceDTO(NoticiaEntity entity) {
        if (entity != null) {
            NoticiaDTO dto = new NoticiaDTO();
            dto.setTitulo(entity.getTitulo());
            dto.setCuerpo(entity.getCuerpo());
            dto.setFechaInicial(entity.getFechaInicial());
            dto.setFechaFinal(entity.getFechaFinal());
            return dto;
        } else {
            return null;
        }
    }

    public static NoticiaEntity persistenceDTO2Entity(NoticiaDTO dto) {
        if (dto != null) {
            NoticiaEntity entity = new NoticiaEntity();
            entity.setTitulo(dto.getTitulo());

            entity.setCuerpo(dto.getCuerpo());

            entity.setFechaInicial(dto.getFechaInicial());
            
            entity.setFechaFinal(dto.getFechaFinal());

            return entity;
        } else {
            return null;
        }
    }

    public static List<NoticiaDTO> entity2PersistenceDTOList(List<NoticiaEntity> entities) {
        List<NoticiaDTO> dtos = new ArrayList<NoticiaDTO>();
        for (NoticiaEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<NoticiaEntity> persistenceDTO2EntityList(List<NoticiaDTO> dtos) {
        List<NoticiaEntity> entities = new ArrayList<NoticiaEntity>();
        for (NoticiaDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
