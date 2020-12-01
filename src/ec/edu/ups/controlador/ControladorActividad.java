/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Actividad;
import java.util.List;

/**
 *
 * @author Paul Idrovo
 */
public class ControladorActividad {
    public void crear(Actividad actividad){
        actividad.crearActividad(actividad);
    }
    
    public List<Actividad> listaActividades(int cursoId){
         List<Actividad> actividads = new Actividad().listaActividades(cursoId);
         return actividads;
    }
    
    public List<Actividad> listaDatosActividades(int actividadId){
         List<Actividad> actividads = new Actividad().datosActividades(actividadId);
         return actividads;
    }
}
