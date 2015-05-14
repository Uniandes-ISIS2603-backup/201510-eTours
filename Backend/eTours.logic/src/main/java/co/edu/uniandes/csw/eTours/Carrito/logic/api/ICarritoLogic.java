/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Carrito.logic.api;

import co.edu.uniandes.csw.eTours.Carrito.logic.dto.CarritoDTO;
import java.util.List;

/**
 *
 * @author estudiante
 */
public interface ICarritoLogic 
{
    public CarritoDTO agregarItem(CarritoDTO details);

    public List<CarritoDTO> getItems();

    public void deleteItem(int id_servicio);

    public void pagarCarrito();

    public void desocuparCarrito();
    
    
        public CarritoDTO getCarrito(Integer page, Integer maxRecords);

    public CarritoDTO getCarrito(Long asd);


    public void deleteCarrito(Long id);

    public void updateCarrito(CarritoDTO detail);
}
