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
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul Idrovo
 */
public class Usuario extends Persona {

    private int idUs;
    private int personaId;
    private String correo;
    private String password;
    private String rol;

    public Usuario() {
    }

    public Usuario(String correo, String password, String rol) {
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    public int getIdUs() {
        return idUs;
    }

    public Usuario(String correo, String password, String rol, String cedula, String nombre, String apellido, String direccion, Date fecha, String genero) {
        super(cedula, nombre, apellido, direccion, fecha, genero);
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    public void setIdUs(int idUs) {
        this.idUs = idUs;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void crearUsuario(Usuario usuario) {
        String sqlstm = "INSERT INTO  `unidadeducativa`.`usuario` (`personaId`, `correo`, `password`,`rol`) "
                + "VALUES ('" + usuario.getIdUs() + "', '" + usuario.getCorreo() + "', '" + usuario.getPassword() + "', '" + usuario.getRol() + "')";
        try {
            ConexionSql.getConnection();
            Connection conn = ConexionSql.getConn();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlstm);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR DE DATOS", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
        }
    }

    public List<Usuario> listaDocentes() {
        List<Usuario> usuarios = new ArrayList<>();
        String sqlstm = """
                        SELECT pr.id, pr.nombre, pr.apellido FROM unidadeducativa.persona as pr 
                        inner join unidadeducativa.usuario as us on us.personaId = pr.id where rol ='DOCENTE'""";
        try {
            ConexionSql.getConnection();
            Connection conn = ConexionSql.getConn();//Direcion
            Statement stmt = conn.createStatement();//Puerta
            ResultSet rs; //Resultados
            rs = stmt.executeQuery(sqlstm);
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setId(rs.getInt("id"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                usuarios.add(us);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR LISTA DE DOCENTES");
        }
        return usuarios;
    }

    public Usuario validarSesion(Usuario usuario) {
        String sqlstm = "SELECT us.personaId, us.rol, cr.id FROM  `unidadeducativa`.usuario  as us  "
                + "LEFT outer join unidadeducativa.curso as cr on cr.docenteId=us.personaId "
                + "where (correo = '" + usuario.getCorreo() + "') and (password = '" + usuario.getPassword() + "')";
        try {
            ConexionSql.getConnection();
            Connection conn = ConexionSql.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery(sqlstm);
            while (rs.next()) {
                Usuario usDatos = new Usuario();
                usDatos.setPersonaId(rs.getInt("personaId"));
                usDatos.setRol(rs.getString("rol"));
                usDatos.setIdUs(rs.getInt("id"));
                return usDatos;
            }
            stmt.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR INICIO SESION", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
}
