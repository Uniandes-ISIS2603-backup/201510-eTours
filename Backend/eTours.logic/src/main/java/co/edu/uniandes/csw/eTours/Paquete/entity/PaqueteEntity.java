package co.edu.uniandes.csw.eTours.Paquete.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.eTours.Servicio.logic.entity.ServicioEntity;
import javax.persistence.OneToMany;
@Entity
public class PaqueteEntity {

    @Id
    @GeneratedValue(generator = "Paquete")
    private Long id;
    private int descount;
    private String servicios;

     
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDescuento() {
        return descount;
    }

    public void setDescuento(int descuento) {
        this.descount = descuento;
    }
    
    public String getServices()
    {
        return servicios;
    }
    
    public void setServices(String pServicios)
    {
    
        this.servicios =pServicios; 
    }
    
    public void addServices(String pServicio)
    {
    
        servicios +=("|" +pServicio);
    }
    
}
