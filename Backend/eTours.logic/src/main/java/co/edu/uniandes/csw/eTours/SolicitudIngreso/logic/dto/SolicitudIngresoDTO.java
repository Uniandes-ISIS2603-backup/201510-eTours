/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author estudiante
 */
@XmlRootElement
public class SolicitudIngresoDTO {
    
    private Long id;
    private String fecha;
    private int estado;
    private Long idProveedor;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setFecha(String pFecha) {
        this.fecha = pFecha;
    }

    public String getFecha() {
        return fecha;
    }

    public int getEstado() {
        return estado;
    }
    
    public void setEstado(int pEstado) {
        this.estado = pEstado;
    }
    
    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }
}
