/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.service;

import co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.api.ISolicitudIngresoLogic;
import co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.dto.SolicitudIngresoDTO;
import co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.dto.SolicitudIngresoPageDTO;
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
@Path("/sols/ingreso")
public class SolicitudIngresoService {
     @Inject
    protected ISolicitudIngresoLogic ingresoLogicService;
     
     @GET
     public SolicitudIngresoPageDTO getSolsIngreso(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords){
         return ingresoLogicService.getSolicitudesIngreso(page, maxRecords);
     }
     

     @GET
     @Path("estado/{tipo}")
     public SolicitudIngresoPageDTO getSolsIngresoEstado(@PathParam("estado") int id, @QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords){
         return ingresoLogicService.getSolicitudesIngresoEstado(id, page, maxRecords);
     }
     
     @GET
     @Path("fecha/{fecha}")
     public SolicitudIngresoPageDTO getSolsIngresoFecha(@PathParam("fecha") String fecha, @QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords){
         return ingresoLogicService.getSolicitudesIngresoFecha(fecha, page, maxRecords);
     }
     
     @GET
     @Path("{id}")
     public SolicitudIngresoDTO getSolIngreso(@PathParam("id") Long id){
         return ingresoLogicService.getSolicitudIngreso(id);
     }
    
     @POST
     public SolicitudIngresoDTO createSolicitudIngreso(SolicitudIngresoDTO detail){
         return ingresoLogicService.createSolicitudIngreso(detail);
     }
     
     @DELETE
     @Path("{id}")
     public void deleteSolicitudIngreso(@PathParam("id") Long id){
         ingresoLogicService.deleteSolicitudIngreso(id);
     }
     
     @PUT
     @Path("{id}/{estado}")
     public SolicitudIngresoDTO updateSolIngreso(@PathParam("id") Long id, @PathParam("estado") int estado){
         return ingresoLogicService.updateSolicitudIngreso(id, estado);
     }
     
}
