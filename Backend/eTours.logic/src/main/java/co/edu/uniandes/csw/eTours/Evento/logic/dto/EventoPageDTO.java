/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Evento.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author estudiante
 */
public class EventoPageDTO {
    
    private Long totalRecords;

    private List<EventoDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<EventoDTO> getRecords() {
        return records;
    }

    public void setRecords(List<EventoDTO> records) {
        this.records = records;
    }
}
