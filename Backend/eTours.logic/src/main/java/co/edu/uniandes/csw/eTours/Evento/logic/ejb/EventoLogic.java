/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Evento.logic.ejb;

import co.edu.uniandes.csw.eTours.Evento.logic.api.IEventoLogic;
import co.edu.uniandes.csw.eTours.Evento.logic.dto.EventoDTO;
import co.edu.uniandes.csw.eTours.Evento.logic.dto.EventoPageDTO;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class EventoLogic implements IEventoLogic{

    public EventoDTO createEvento(EventoDTO detail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EventoDTO> getEventos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EventoPageDTO getEventos(Integer page, Integer maxRecords) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EventoDTO getEvento(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteEvento(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateEvento(EventoDTO detail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String formatFecha(int tipo, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
