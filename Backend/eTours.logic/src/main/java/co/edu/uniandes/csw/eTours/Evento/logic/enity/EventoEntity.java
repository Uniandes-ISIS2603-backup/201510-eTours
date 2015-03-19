/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Evento.logic.enity;


import java.util.Date;
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
public class EventoEntity {
    
    @Id
    @GeneratedValue(generator = "Evento")
    private Long id;
    private String lugar;
    private String organizador;
    private Long inicio;
    private Long fin;
    private String contacto;
    private boolean req_inscripcion;
    private Long id_publicador;
    
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    
    public String getLugar(){
        return lugar;
    }
    public void setLugar(String lugar){
        this.lugar = lugar;
    }
    
    public String getOrganizador(){
        return organizador;
    }
    public void setOrganizador(String organizador){
        this.organizador = organizador;
    }
    
    public Long getInicio(){
        return inicio;
    }
    public void setInicio(Long inicio){
        this.inicio = inicio;
    }
    
    public Long getFin(){
        return fin;
    }
    public void setFin(Long fin){
        this.fin = fin;
    }
    
    public String getContacto(){
        return contacto;
    }
    public void setContacto(String contacto){
        this.contacto = contacto;
    }
    
    public boolean getReqInscripcion(){
        return req_inscripcion;
    }
    public void setReqInscripcion(boolean req_inscripcion){
        this.req_inscripcion = req_inscripcion;
    }
    
    public Long getIdPublicador(){
        return id_publicador;
    }
    public void setIdPublicador(Long id_publicador){
        this.id_publicador = id_publicador;
    }
    
}
