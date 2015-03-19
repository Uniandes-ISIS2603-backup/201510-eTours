/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Noticia.logic.dto;

import java.util.List;

/**
 *
 * @author estudiante
 */
public class NoticiaPageDTO {
    private Long totalRecords;

    private List<NoticiaDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<NoticiaDTO> getRecords() {
        return records;
    }

    public void setRecords(List<NoticiaDTO> records) {
        this.records = records;
    }
}
