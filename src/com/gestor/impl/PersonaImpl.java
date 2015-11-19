/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.impl;

import com.gestor.daos.PersonaDAO;
import com.gestor.modelo.Persona;
import com.gestor.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author joaquin14
 */
public class PersonaImpl implements PersonaDAO {

    @Override
    public List<Persona> listar() {

        Vector<Persona> listarPersonas = new Vector();
        try {

            Connection conexion = Conexion.getConexion();
            String sql = "SELECT * FROM personas";
            PreparedStatement pstm = conexion.prepareStatement(sql);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {
                Persona persona = new Persona();
                persona.setNombre(resultado.getString("nombre"));
                persona.setApellido(resultado.getString("apellido"));
                persona.setDni(resultado.getLong("dni"));
                persona.setTelefono(resultado.getString("telefono"));
                persona.setDireccion(resultado.getString("direccion"));

                listarPersonas.add(persona);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error " + e);

        }

        return listarPersonas;
    }

    
    
    public static void main(String... a){
        
        PersonaDAO service = new PersonaImpl();
        List<Persona> personas = service.listar();
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}
