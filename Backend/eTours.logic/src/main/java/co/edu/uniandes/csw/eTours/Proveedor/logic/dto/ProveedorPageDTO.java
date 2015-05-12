package com.edu.uniandes.scw.eTours.Proveedor.logic.dto;

import co.edu.uniandes.csw.eTours.Paquete.logic.dto.*;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProveedorPageDTO {
    private Long totalRecords;

    private List<PaqueteDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<PaqueteDTO> getRecords() {
        return records;
    }

    public void setRecords(List<PaqueteDTO> records) {
        this.records = records;
    }
}
