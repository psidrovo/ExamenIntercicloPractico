/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul Idrovo
 */
public class Persona {

    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private Date fecha;
    private String genero;

    public Persona() {
    }

    public Persona(String cedula, String nombre, String apellido, String direccion, Date fecha, String genero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fecha = fecha;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean crearPersona(Persona persona) {
        String sqlstm = "INSERT INTO  `unidadeducativa`.`persona` (`cedula`, `nombre`,`apellido`,`direccion`,`fechaNacimiento`, `genero`) "
                + "VALUES ('" + persona.getCedula() + "', '" + persona.getNombre() + "', '" + persona.getApellido() + "', '" + persona.getDireccion() + "', '" + persona.getFecha() + "','" + persona.getGenero() + "')";
        try {
            ConexionSql.getConnection();
            Connection conn = ConexionSql.getConn();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlstm);
            return true;
        } catch (Exception e) {
            switch (e.getMessage()) {
                case "Data truncation: Incorrect date value: 'null' for column 'fechaNacimiento' at row 1" -> {
                    JOptionPane.showMessageDialog(null, "FORMATO DE FECHA NO VALIDA", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                case "Data truncated for column 'genero' at row 1" -> {
                    JOptionPane.showMessageDialog(null, "SELECCIONE UN GENERO", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "YA EXISTE UNA CEDULA REGISTRADA CON ESE NUMERO", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
        }
    }

    public int idPersona(String cedula) {
        String sqlstm = "SELECT id FROM unidadeducativa.persona where cedula = '" + cedula + "'";
        try {
            ConexionSql.getConnection();
            Connection conn = ConexionSql.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sqlstm);
            while (rs.next()) {
                return rs.getInt("id");
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR CEDULA", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
        }
        return 0;

    }

}
