/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.service;

import co.edu.uniandes.csw.eTours.Evento.logic.api.IEventoLogic;
import co.edu.uniandes.csw.eTours.Evento.logic.dto.EventoDTO;
import co.edu.uniandes.csw.eTours.Evento.logic.dto.EventoPageDTO;
import co.edu.uniandes.csw.eTours.Evento.logic.enity.EventoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author estudiante
 */
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/evento")
public class EventoService {
    
    @Inject
    protected IEventoLogic eventoLogicService;

    @POST
    public EventoDTO createEvento(EventoDTO detail) {
        return eventoLogicService.createEvento(detail);
    }
    
    @GET
    public List<EventoDTO> getEventos(){
        return eventoLogicService.getEventos();
    }
    
    @GET
    public EventoPageDTO getEventos(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords){
        return eventoLogicService.getEventos(page, maxRecords);
    }
    @GET
    @Path("{id}")
    public EventoDTO getEvento(@PathParam("id") Long id){
        return eventoLogicService.getEvento(id);
    }
    
    @DELETE
    @Path("{id}")
    public void deleteEvento(@PathParam("id") Long id){
        eventoLogicService.deleteEvento(id);
    }
    
    @PUT
    public void updateEvento(@PathParam("id") Long id, EventoDTO detail){
        eventoLogicService.updateEvento(detail);
    } 


    @GET
    @Path("{id}")
    public String formatFecha(@QueryParam("tipo") Integer tipo, @PathParam("id") Long id) throws Exception{
        return eventoLogicService.formatFecha(tipo, id);
    }

    
    
}
