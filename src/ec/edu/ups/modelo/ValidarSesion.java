/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Paul Idrovo
 */
public class ValidarSesion {

    private int id;
    private int curso;
    private static ValidarSesion miconfigurador;

    public static synchronized ValidarSesion getValidarSesion(int id,int curso) {

        if (miconfigurador == null) {

            miconfigurador = new ValidarSesion(id,curso);
        }
        return miconfigurador;
    }

    private ValidarSesion(int id, int curso) {        
        this.id = id;
        this.curso=curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    
    
}
