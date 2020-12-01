/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Estudiante;
import ec.edu.ups.modelo.Persona;
import java.util.List;

/**
 *
 * @author Paul Idrovo
 */
public class ControladorEstudiante {
    public void crear(Estudiante estudiante){
        if(estudiante.crearPersona((Persona)estudiante)){
            int idPersona = estudiante.idPersona(estudiante.getCedula());
            estudiante.setIdEs(idPersona);
            estudiante.crearEstudiante(estudiante);
        }
    }
    
    public List<Estudiante> listaEstudiantes(int id){
         List<Estudiante> estudiantes = new Estudiante().listaEstudiantes(id);
         return estudiantes;
    }
}
