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
public class DatoActividad {
    private int id;
    private int actividadId;
    private String titulo;
    private String link;

    public DatoActividad() {
    }

    public DatoActividad(int id, int actividadId, String titulo, String link) {
        this.id = id;
        this.actividadId = actividadId;
        this.titulo = titulo;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

   
    
}
