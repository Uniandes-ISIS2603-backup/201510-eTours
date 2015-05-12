/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Carrito.logic.api;

import co.edu.uniandes.csw.eTours.Servicio.logic.dto.ServicioDTO;
import java.util.List;

/**
 *
 * @author estudiante
 */
public interface ICarritoLogic 
{
    public ServicioDTO agregarItem(ServicioDTO details);

    public List<ServicioDTO> getItems();

    public void deleteItem(int id_servicio);

    public void pagarCarrito();

    public void desocuparCarrito();
}
