package co.edu.uniandes.csw.eTours.Paquete.logic.dto;

import co.edu.uniandes.csw.eTours.Servicio.logic.entity.ServicioEntity;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaqueteDTO {
   
        private Long id;
    
   private Double descount;
    private String servicios ;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDescuento() {
        return descount;
    }

    public void setDescuento(Double descuento) {
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
    
        servicios += ("|"+ pServicio);
    }
    
}
