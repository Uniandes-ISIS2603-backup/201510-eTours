/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Noticia.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Laura Cortes
 */
@Entity
public class NoticiaEntity {
    
    @Id
    private String titulo;
    
    private String cuerpo;
   
    private Date fechaInicial;
    
    private Date fechaFinal;
    
    
    public String getTitulo()
    {
        return this.titulo;
    }
    
    public void setTitulo(String titulo)
    {
        this.titulo=titulo;
    }
    
    public String getCuerpo()
    {
        return this.cuerpo;
    }
    
    public void setCuerpo(String cuerpo)
    {
        this.cuerpo=cuerpo;
    }
    
    public Date getFechaInicial()
    {
        return this.fechaInicial;
    }
    
    public void setFechaInicial(Date fechaInicial)
    {
        this.fechaInicial=fechaInicial;
    }
    
    public Date getFechaFinal()
    {
        return this.fechaFinal;
    }
    
    public void setFechaFinal(Date fechaFinal)
    {
        this.fechaFinal=fechaFinal;
    }
}
