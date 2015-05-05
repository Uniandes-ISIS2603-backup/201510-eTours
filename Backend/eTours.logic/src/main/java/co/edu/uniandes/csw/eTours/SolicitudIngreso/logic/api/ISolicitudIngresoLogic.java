/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.api;

import co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.dto.SolicitudIngresoDTO;
import co.edu.uniandes.csw.eTours.SolicitudIngreso.logic.dto.SolicitudIngresoPageDTO;
import java.util.List;

/**
 *
 * @author estudiante
 */

//GET	/sols/ingreso/	Obtiene todas las solicitudes de ingreso en el aplicativo
// 
// Coleccion JSON con instancias de solicitudes de ingreso
// 
// GET	/sols/ingreso/estado/:tipo	Obtiene todas las solicitudes de ingreso que están en estado aprobadas o en espera
// @PathParam tipo: Tipo de la solicitud: (1:aprobadas || 0: en espera )
// Coleccion JSON con instancias de solicitudes de ingreso
// 
// GET	/sols/ingreso/fecha/:fecha	Obtiene todas las solicitudes de ingreso que se generaron en una fecha dada por parámetro	 @PathParam fecha: Fecha de la que se desean conocer las solicitudes	 Coleccion JSON con instancias de solicitudes que cumplen con los parámetros
// 
// GET	/sols/ingreso/:id	 Obtiene la solicitud de retiro que tiene el id indicado por parámetro	 @PathParam id: Id de la solicitud que se desea conocer	 Objeto JSON de la solicitud	 
// POST	/sols/ingreso/	Agregar una nueva instancia de solicitud
// Objeto JSON de la entidad
// Objeto JSON de la entidad creada
// 
// DELETE	/sols/ingreso/:id	Elimina una instancia de solicitud.
// @PathParam id:
//Id de la solicitud que se desea eliminar.
// Coleccion JSON de solicitudes, sin la eliminada.
// 
// UPDATE	/sols/ingreso/:id/:estado

public interface ISolicitudIngresoLogic {
    public SolicitudIngresoDTO createSolicitudIngreso(SolicitudIngresoDTO detail);
    
    public SolicitudIngresoDTO getSolicitudIngreso(Long id);

    public void deleteSolicitudIngreso(Long id);

    public SolicitudIngresoDTO updateSolicitudIngreso(Long id, int pNuevoEstado);

    public List<SolicitudIngresoDTO> getSolicitudesIngreso();
            
    public SolicitudIngresoPageDTO getSolicitudesIngreso(Integer page, Integer maxRecords);
    
    public List<SolicitudIngresoDTO> getSolicitudesIngresoEstado(int pEstado);
    
    public SolicitudIngresoPageDTO getSolicitudesIngresoEstado( int pEstado, Integer page, Integer maxRecords);
    
    public List<SolicitudIngresoDTO> getSolicitudesIngresoFecha(String pFecha);
    
    public SolicitudIngresoPageDTO getSolicitudesIngresoFecha( String pFecha, Integer page, Integer maxRecords);
    
    public List<SolicitudIngresoDTO> getSolicitudesIngresoProveedor(Long id_Proveedor);

    public SolicitudIngresoPageDTO getSolicitudesIngresoProveedor(Long id_Proveedor, Integer page, Integer maxRecords);


}
