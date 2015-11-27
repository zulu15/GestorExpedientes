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
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public void eliminar(long id) throws Exception {
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM personas WHERE dni = ?";
            Connection conexion = Conexion.getConexion();
            pstm = conexion.prepareStatement(sql);
            pstm.setLong(1, id);
            int registros = pstm.executeUpdate();
            if (registros != 1) {
                throw new RuntimeException("Error se afectaron varios registros");
            }

        } catch (Exception e) {
            throw new RuntimeException("No pude eliminar la persoba"
                    + " con id " + id + " -- " + e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    @Override
    public void actualizar(Persona persona) throws Exception {

        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE personas SET nombre = ? , apellido = ? , telefono = ? , direccion = ? WHERE dni = ?";
            Connection conexion = Conexion.getConexion();
            pstm = conexion.prepareStatement(sql);
            pstm.setString(1, persona.getNombre());
            pstm.setString(2, persona.getApellido());
            pstm.setString(3, persona.getTelefono());
            pstm.setString(4, persona.getDireccion());
            pstm.setLong(5, persona.getDni());

            int registros = pstm.executeUpdate();
            if (registros != 1) {
                throw new RuntimeException("Error se afectaron varios registros");
            }
        } catch (Exception e) {
            throw new RuntimeException("No pude actualizar la persona " + persona + " --" + e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    @Override
    public void insertar(Persona persona) throws Exception {

        PreparedStatement pstm = null;
        try {
            String sql = "INSERT INTO personas (dni, nombre, apellido,telefono,direccion) VALUES (?,?,?,?,?)";
            Connection conexion = Conexion.getConexion();
            pstm = conexion.prepareStatement(sql);
            pstm.setLong(1, persona.getDni());
            pstm.setString(2, persona.getNombre());
            pstm.setString(3, persona.getApellido());
            pstm.setString(4, persona.getTelefono());
            pstm.setString(5, persona.getDireccion());
            int registros = pstm.executeUpdate();
            if (registros != 1) {
                throw new RuntimeException("Error se afectaron " + registros + " registros");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error insertando PERSONA" + e);
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
    
    
    //Test metodos
    public static void main(String... a){
        Persona persona = new Persona(11456465, "NOMBRE ACTUALIZADO", "Prueba apellido", "Prueba telefono","DIRECCION ACTUALIZADA");
        PersonaImpl servicio = new PersonaImpl();
        try {
          //  servicio.insertar(persona);
          //  servicio.actualizar(persona);
          //  servicio.eliminar(11456465);
  /*          
            List<Persona> personas = servicio.listar();
            for (Persona persona1 : personas) {
                System.out.println("Persona: "+persona1);
            }
    */        
        } catch (Exception ex) {
            Logger.getLogger(PersonaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
}
