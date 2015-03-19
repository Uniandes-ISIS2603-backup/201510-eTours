/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Evento.logic.api;

import co.edu.uniandes.csw.eTours.Evento.logic.dto.EventoDTO;
import co.edu.uniandes.csw.eTours.Evento.logic.dto.EventoPageDTO;
import java.util.List;

/**
 *
 * @author estudiante
 */
public interface IEventoLogic {
    
    public EventoDTO createEvento(EventoDTO detail);

    public List<EventoDTO> getEventos();

    public EventoPageDTO getEventos(Integer page, Integer maxRecords);

    public EventoDTO getEvento(Long id);

    public void deleteEvento(Long id);

    public void updateEvento(EventoDTO detail);
    
    public String formatFecha(int tipo, Long id);
    
}
