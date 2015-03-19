/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Evento.logic.ejb;

import co.edu.uniandes.csw.eTours.Evento.logic.api.IEventoLogic;
import co.edu.uniandes.csw.eTours.Evento.logic.converter.EventoConverter;
import co.edu.uniandes.csw.eTours.Evento.logic.dto.EventoDTO;
import co.edu.uniandes.csw.eTours.Evento.logic.dto.EventoPageDTO;
import co.edu.uniandes.csw.eTours.Evento.logic.enity.EventoEntity;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author estudiante
 */
public class EventoLogic implements IEventoLogic{
    
    @PersistenceContext(unitName = "eToursClassPU")
    protected EntityManager entityManager;
    
    private static final int INICIO = 1;
    private static final int FIN = 2;

    
    public EventoDTO createEvento(EventoDTO detail) {
        EventoEntity entity = EventoConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return EventoConverter.entity2PersistenceDTO(entity);
    }

    public List<EventoDTO> getEventos() {
        Query q = entityManager.createQuery("select u from EventoEntity u");
        return EventoConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public EventoPageDTO getEventos(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from EventoEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from EventoEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        EventoPageDTO response = new EventoPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(EventoConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public EventoDTO getEvento(Long id) {
        return EventoConverter.entity2PersistenceDTO(entityManager.find(EventoEntity.class, id));
    }

    public void deleteEvento(Long id) {
        EventoEntity entity = entityManager.find(EventoEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateEvento(EventoDTO detail) {
        EventoEntity entity = entityManager.merge(EventoConverter.persistenceDTO2Entity(detail));
        EventoConverter.entity2PersistenceDTO(entity);
    }

    public String formatFecha(int tipo, Long id) throws Exception {
        
        EventoEntity entity = entityManager.find(EventoEntity.class, id);
        Long tFecha = 0L;
        if (tipo==INICIO){
            tFecha = entity.getInicio();
        }
        else if (tipo==FIN){
            tFecha = entity.getFin();
        }
        else{
            throw new Exception("El tipo recibido por parametro no es valido en la clase 'Evento'");
        }
        
        Date fecha = new Date(tFecha);
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        String[] weekday;
        weekday = new String[]{"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
        String[] monthNames;
        monthNames = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                                    "Julio", "Augosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
     
                
//        var dia = fechaEvento.getDate();                
//                var nombreMes = monthNames[fechaEvento.getMonth()];
//                var nombreDia = weekday[fechaEvento.getDay()];
//                
//                 var fechaString = nombreDia+', '+dia+' de '+nombreMes;
        
        int dia = cal.get(Calendar.DATE);
        String nombreMes = monthNames[cal.get(Calendar.MONTH)];
        String nombreDia = weekday[cal.get(Calendar.DAY_OF_WEEK)];
        String format = nombreDia+", "+dia+" de "+nombreMes;
        return format;
    }
        
    
}
