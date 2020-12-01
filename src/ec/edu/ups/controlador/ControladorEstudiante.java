/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Estudiante;
import ec.edu.ups.modelo.Persona;

/**
 *
 * @author Paul Idrovo
 */
public class ControladorEstudiante {
    public void Crear(Estudiante estudiante){
        if(estudiante.crearPersona((Persona)estudiante)){
            int idPersona = estudiante.idPersona(estudiante.getCedula());
            estudiante.setIdEs(idPersona);
            estudiante.crearEstudiante(estudiante);
        }
    }
}
