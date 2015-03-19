/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Paquete.logic.api;

import co.edu.uniandes.csw.eTours.Paquete.logic.dto.PaqueteDTO;
import co.edu.uniandes.csw.eTours.Paquete.logic.dto.PaquetePageDTO;
import java.util.List;

/**
 *
 * @author afesguerra
 */
public interface IPaqueteLogic {

     public PaqueteDTO createPaquete(PaqueteDTO detail);
       
    
     public List<PaqueteDTO> getPaquetes();
    
    
    public PaquetePageDTO getPaquete(Integer page, Integer maxRecords);

       
    
    public PaqueteDTO getPaquete(Long id);


    public void deletePaquete(Long id);

    public void updatePaquete(PaqueteDTO detail);
    
    
    
    
    public List<PaqueteDTO> getServices();
    
    
}
