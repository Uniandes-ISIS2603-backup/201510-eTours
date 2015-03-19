/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.Noticia.logic.api;

import co.edu.uniandes.csw.eTours.Noticia.logic.dto.NoticiaDTO;
import co.edu.uniandes.csw.eTours.Noticia.logic.dto.NoticiaPageDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Laura Cortes
 */
public interface INoticiaLogic 
{
    public NoticiaDTO createNoticia(NoticiaDTO details);
    
    public List<NoticiaDTO> getNoticias();
    
    public NoticiaDTO getNoticiaTitulo(String titulo);
    
    public void deleteNoticia(String titulo);
    
    public void updateNoticia(NoticiaDTO details);
    
    public List<NoticiaDTO> getNoticiasFecha(Date fechaInicial);
    
    public NoticiaPageDTO getNoticia(Integer page, Integer maxRecords);
}
