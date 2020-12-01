/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul Idrovo
 */
public class Actividad {
    private int id;
    private int cursoId;
    private String tema;

    public Actividad() {
    }

    public Actividad(int cursoId, String tema) {
        this.cursoId = cursoId;
        this.tema = tema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public void crearActividad(Actividad actividad){
        String sqlstm = "INSERT INTO  `unidadeducativa`.`actividad` (`cursoId`, `tema`) "
                + "VALUES ('" + actividad.getCursoId()+ "', '" + actividad.getTema()+ "')";
        try {
            ConexionSql.getConnection();
            Connection conn = ConexionSql.getConn();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DE DATOS", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
        }
    }
}
