/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author estudiante
 */
@Entity
public class SolicitudIngresoEntity {
    @Id
    @GeneratedValue(generator = "SolicitudIngreso")
    
    private Long id;
    private Long idProveedor;    
    private String fecha;
    private int estado;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    public String getFechaCreacion() {
        return fecha;
    }

    public void setFechaCreacion(String fecha) {
        this.fecha = fecha;
    }
}
