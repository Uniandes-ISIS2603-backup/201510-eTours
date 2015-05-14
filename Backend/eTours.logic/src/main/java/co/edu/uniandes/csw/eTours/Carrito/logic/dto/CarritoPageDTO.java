/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Carrito.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;
import co.edu.uniandes.csw.eTours.Carrito.logic.dto.CarritoDTO;
import java.util.List;
/**
 *
 * @author estudiante
 */
@XmlRootElement

public class CarritoPageDTO {
        private Long totalRecords;

    private List<CarritoDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<CarritoDTO> getRecords() {
        return records;
    }

    public void setRecords(List<CarritoDTO> records) {
        this.records = records;
    }
    
}
