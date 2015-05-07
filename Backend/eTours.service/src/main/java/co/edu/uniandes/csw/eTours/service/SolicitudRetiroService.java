/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.service;

import co.edu.uniandes.csw.eTours.SolicitudRetiro.logic.api.ISolicitudRetiroLogic;
import co.edu.uniandes.csw.eTours.SolicitudRetiro.logic.dto.SolicitudRetiroDTO;
import java.util.Date;
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
 * @author Brahian David Rangel
 */

@Path("/sols/retiro/")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SolicitudRetiroService 
{
    @Inject
    protected ISolicitudRetiroLogic solicitudRetiroLogicService;
    
    @POST
    public SolicitudRetiroDTO createSolicitudRetiro(SolicitudRetiroDTO nSolRetiro) 
    {
        return solicitudRetiroLogicService.createSolicitudRetiro(nSolRetiro);
    }
    
    @DELETE
    @Path("{id}")
    public List<SolicitudRetiroDTO> deleteSolicitudRetiro(@PathParam("id") String idSolicitud) {
        solicitudRetiroLogicService.deleteSolicitudRetiro(Long.parseLong(idSolicitud));
        return solicitudRetiroLogicService.getSolicitudesRetiro();
    }
    
    @GET
    public List<SolicitudRetiroDTO> getSolicitudesRetiro() {
        return solicitudRetiroLogicService.getSolicitudesRetiro();
    }
    
    @GET
    @Path("{idSol}")
    public SolicitudRetiroDTO getSolicitudRetiro(@PathParam("idSol") Long pId) {
        return solicitudRetiroLogicService.getSolicitudRetiro(pId);
    }
    
    
    @GET
    @Path("estado/{tipo}")
    public List<SolicitudRetiroDTO> getSolicitudesRetiroEstado(@PathParam("tipo") Integer estado) {
        return solicitudRetiroLogicService.getSolicitudesRetiroEstado(estado);
    }
    
    @GET
    @Path("fecha/{fecha}")
    public List<SolicitudRetiroDTO> getSolicitudesRetiroFecha(@PathParam("fecha") String pFecha) {
        return solicitudRetiroLogicService.getSolicitudesRetiroFecha(pFecha);
    }
    
    @GET
    @Path("proveedor/{idProv}")
    public List<SolicitudRetiroDTO> getSolicitudesRetiroProv(@PathParam("idProv") Long pIdProveedor) {
        return solicitudRetiroLogicService.getSolicitudesRetiroProveedor(pIdProveedor);
    }
    
    @PUT
    @Path("{idSol}/{nEstado}")
    public SolicitudRetiroDTO setSolicitudRetiro(@PathParam("idSol") Long pIdSolicitud,@PathParam("nEstado") Integer pNuevoEstado ) {
        return solicitudRetiroLogicService.updateSolicitudRetiro(pIdSolicitud, pNuevoEstado);
    }

    
}
