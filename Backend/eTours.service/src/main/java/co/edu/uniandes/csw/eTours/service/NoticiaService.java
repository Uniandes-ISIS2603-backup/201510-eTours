/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.service;

import co.edu.uniandes.csw.eTours.Noticia.logic.api.INoticiaLogic;
import co.edu.uniandes.csw.eTours.Noticia.logic.dto.NoticiaDTO;
import co.edu.uniandes.csw.eTours.Noticia.logic.dto.NoticiaPageDTO;
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
@Path("/noticia")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NoticiaService 
{
    
    @Inject
    protected INoticiaLogic noticiaLogicService;
    
    @POST
    public NoticiaDTO createNoticia(NoticiaDTO not) 
    {
        return noticiaLogicService.createNoticia(not);
    }
    
     @DELETE
    @Path("{titulo}")
    public void deleteNoticia(@PathParam("titulo") String titulo) {
        noticiaLogicService.deleteNoticia(titulo);
    }
    
    @GET
    public NoticiaPageDTO getNoticia(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return noticiaLogicService.getNoticia(page, maxRecords);
    }
    
    @GET
    @Path("{titulo}")
    public NoticiaDTO getNoticia(@PathParam("titulo") String titulo) {
        return noticiaLogicService.getNoticiaTitulo(titulo);
    }
    
     @PUT
    public void updateNoticia(@PathParam("titulo") String titulo, NoticiaDTO not) {
        noticiaLogicService.updateNoticia(not);
    }
}
