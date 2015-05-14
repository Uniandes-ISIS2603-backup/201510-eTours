/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Carrito.logic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author estudiante
 */
@Entity
@XmlRootElement
public class CarritoEntity {
    @Id
    @GeneratedValue(generator = "Carrito")
    private Long id;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
}
