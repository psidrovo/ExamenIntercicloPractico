/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.modelo.Persona;
import java.util.List;

/**
 *
 * @author Paul Idrovo
 */
public class ControladorUsuario {
    public void crear(Usuario usuario){
        if(usuario.crearPersona((Persona)usuario)){
            int idPersona = usuario.idPersona(usuario.getCedula());
            usuario.setIdUs(idPersona);
            usuario.crearUsuario(usuario);
        }
    }
    
    public List<Usuario> listaDocentes(){
         List<Usuario> usuarios = new Usuario().listaDocentes();
         return usuarios;
    }
}
