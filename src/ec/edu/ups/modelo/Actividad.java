/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul Idrovo
 */
public class Actividad extends DatoActividad{
    private int id;
    private int cursoId;
    private String tema;

    public Actividad() {
    }

    public Actividad(int cursoId, String tema) {
        this.cursoId = cursoId;
        this.tema = tema;
    }

    public Actividad(String tema, int id, int actividadId, String titulo, String link) {
        super(actividadId, titulo, link);
        this.id = id;
        this.cursoId = cursoId;
        this.tema = tema;
    }

    public Actividad(int actividadId, String titulo, String link) {
        super(actividadId, titulo, link);
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
    
    public List<Actividad> listaActividades(int idCurso){
        List<Actividad> actividads = new ArrayList<>();
        String sqlstm = "SELECT * FROM unidadeducativa.actividad where cursoId = " + idCurso;
        try {
            ConexionSql.getConnection();
            Connection conn = ConexionSql.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sqlstm);
            while (rs.next()) {
                Actividad act = new Actividad();
                act.setId(rs.getInt("id"));
                act.setTema(rs.getString("tema"));
                actividads.add(act);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR LISTA DE ACTIVIDADES");
        }
        return actividads;
    }
    
    public List<Actividad> datosActividades(int actividadId){
        List<Actividad> actividades = new ArrayList<>();
        String sqlstm = "SELECT * FROM unidadeducativa.datoactividad where actividadId = " + actividadId;
        try {
            ConexionSql.getConnection();
            Connection conn = ConexionSql.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs; 
            rs = stmt.executeQuery(sqlstm);
            while (rs.next()) {
                Actividad act = new Actividad();
                act.setId(rs.getInt("id"));
                act.setTema(rs.getString("titulo"));
                act.setLink(rs.getString("link"));
                actividades.add(act);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR LISTA DE DATOS ACTIVIDADES");
        }
        return actividades;
    }
    public void eliminarDatosActividades(int idActividad){
        String sqlstm = "DELETE FROM `unidadeducativa`.`datoactividad` WHERE (`actividadId` = '"+ idActividad+"');";
        try {
            ConexionSql.getConnection();
            Connection conn = ConexionSql.getConn();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DE DATOS", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void crearDatoActividad(Actividad actividad){
        String sqlstm = "INSERT INTO  `unidadeducativa`.`datoactividad` (`actividadId`, `titulo`, `link`) "
                + "VALUES ('" + actividad.getActividadId()+ "', '" + actividad.getTitulo()+ "', '" + actividad.getTitulo()+ "')";
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
