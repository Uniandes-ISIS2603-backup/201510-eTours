/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.service;
import co.edu.uniandes.csw.eTours.Carrito.logic.api.ICarritoLogic;

import co.edu.uniandes.csw.eTours.Carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.csw.eTours.Carrito.logic.dto.CarritoPageDTO;
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
@Path("/carrito")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarritoService 
{
@Inject 
    protected ICarritoLogic carritoLogicService;

    @POST
    public CarritoDTO createCarrito(CarritoDTO paq) {
        return carritoLogicService.createCarrito(paq);
    }

    @DELETE
    @Path("{id}")
    public void deleteCarrito(@PathParam("id") Long id) {
        carritoLogicService.deleteCarrito(id);
    }

    @GET
    public CarritoPageDTO getCarrito(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return carritoLogicService.getCarrito(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public CarritoDTO getCarrito(@PathParam("id") Long id) {
        return carritoLogicService.getCarrito(id);
    }

    @PUT
    @Path("{id}")
    public void updateCarrito(@PathParam("id") Long id, CarritoDTO paq) {
        carritoLogicService.updateCarrito(paq);
    }    
}
