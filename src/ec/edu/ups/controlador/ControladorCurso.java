/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Curso;
import java.util.List;

/**
 *
 * @author Paul Idrovo
 */
public class ControladorCurso {
    public void crear(Curso curso){
        curso.crearCurso(curso);
    }
    public void asignarDocente(Curso curso){
        curso.asignarDocente(curso);
    }
    public List<Curso> listaCursos(){
         List<Curso> cursos = new Curso().listaCursos();
         return cursos;
    }
}
