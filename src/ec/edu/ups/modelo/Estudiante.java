/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul Idrovo
 */
public class Estudiante extends Persona{
    private int idEs;
    private int estudianteId;
    private int crusoId;

    public Estudiante() {
    }

    public Estudiante(int crusoId, String cedula, String nombre, String apellido, String direccion, Date fecha, String genero) {
        super(cedula, nombre, apellido, direccion, fecha, genero);
        this.estudianteId = estudianteId;
        this.crusoId = crusoId;
    }

    

    public int getIdEs() {
        return idEs;
    }

    public void setIdEs(int idEs) {
        this.idEs = idEs;
    }
    

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public int getCrusoId() {
        return crusoId;
    }

    public void setCrusoId(int crusoId) {
        this.crusoId = crusoId;
    }
    
    public void crearEstudiante(Estudiante estudiante){
        String sqlstm = "INSERT INTO  `unidadeducativa`.`estudiante` (`estudianteId`, `crusoID`) "
                + "VALUES ('" + estudiante.getEstudianteId()+ "', '" + estudiante.getCrusoId()+ "')";
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
