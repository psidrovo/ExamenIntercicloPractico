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
public class Curso {
    private int id;
    private int docenteId;
    private String nombre;

    public Curso() {
    }

    public Curso(String nombre) {
        this.nombre = nombre;
    }
    
    public Curso(int id, int docenteId) {
        this.id = id;
        this.docenteId = docenteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(int docenteId) {
        this.docenteId = docenteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void crearCurso(Curso curso){
        String sqlstm = "INSERT INTO  `unidadeducativa`.`curso` (`nombre`) "
                + "VALUES ('" + curso.getNombre()+ "')";
        try {
            ConexionSql.getConnection();
            Connection conn = ConexionSql.getConn();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "YA EXISTE UN CURSO CON ESE NOMBRE", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void asignarDocente(Curso curso){
        String sqlstm = "UPDATE  `unidadeducativa`.`curso` SET `docenteId` = '" + curso.getDocenteId() + "' WHERE `id` = " + curso.getId();
        try {
            ConexionSql.getConnection();
            Connection conn = ConexionSql.getConn();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlstm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ESTE DOCENTE YA SE ENCUENTRA ASIGNADO A OTRO CURSO", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public List<Curso> listaCursos(){
         List<Curso> cursos = new ArrayList<>();
        String sqlstm = "SELECT * FROM `unidadeducativa`.`curso`";
        try {
            ConexionSql.getConnection();
            Connection conn = ConexionSql.getConn();//Direcion
            Statement stmt = conn.createStatement();//Puerta
            ResultSet rs; //Resultados
            rs = stmt.executeQuery(sqlstm);
            while (rs.next()) {
                Curso cr = new Curso();
                cr.setId(rs.getInt("id"));
                cr.setNombre(rs.getString("nombre"));
                cursos.add(cr);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR LISTA DE CURSOS");
        }
        return cursos;
    }
}
