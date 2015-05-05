/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.dto;

import java.util.List;

/**
 *
 * @author estudiante
 */
public class SolicitudIngresoPageDTO {
    
    private Long totalRecords;

    private List<SolicitudIngresoDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<SolicitudIngresoDTO> getRecords() {
        return records;
    }

    public void setRecords(List<SolicitudIngresoDTO> records) {
        this.records = records;
    }
}
