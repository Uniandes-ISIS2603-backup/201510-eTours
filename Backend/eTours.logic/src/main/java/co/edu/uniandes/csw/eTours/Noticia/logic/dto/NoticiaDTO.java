/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Noticia.logic.dto;



/**
 *
 * @author estudiante
 */
    public class NoticiaDTO {
    private String titulo;
    
    private String cuerpo;
    
    private String fechaInicial;
    
    private String fechaFinal;
    
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
    
    public String getFechaInicial()
    {
        return this.fechaInicial;
    }
    
    public void setFechaInicial(String fechaInicial)
    {
        this.fechaInicial=fechaInicial;
    }
    
    public String getFechaFinal()
    {
        return this.fechaFinal;
    }
    
    public void setFechaFinal(String fechaFinal)
    {
        this.fechaFinal=fechaFinal;
    }
}
