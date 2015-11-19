/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.impl;

import com.gestor.daos.OperadorDAO;
import com.gestor.modelo.Operador;
import com.gestor.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Luis
 */
public class OperadorImpl implements OperadorDAO {

    public static void main(String a[]) {

        Operador operador = new Operador(1, "Lui2s", "123");

        OperadorDAO service = new OperadorImpl();
        
        
        operador = service.buscarOperador(operador);
       
        if(operador.getClave()!= null &&  operador.getUsuario()!= null ){
            System.out.println(" EXISTE EN LA BASE DE DATOS");
        
        
        }else {System.out.println(" NO EXISTE EN LA BASE DE DATOS");}

        
         

    }

    @Override
    public Operador buscarOperador(Operador operador) {

        Operador operadorEncontrado = new Operador();

        Connection conexion = Conexion.getConexion();
        String sql = "SELECT * FROM operadores  WHERE usuario=? AND clave = ?";

        PreparedStatement pstm;
        ResultSet resultado;

        try {

            pstm = conexion.prepareStatement(sql);

            pstm.setString(1, operador.getUsuario());
            pstm.setString(2, operador.getClave());

            resultado = pstm.executeQuery();

            while (resultado.next()) {

                operadorEncontrado.setClave(resultado.getString("clave"));
                operadorEncontrado.setUsuario(resultado.getString("usuario"));
                operadorEncontrado.setCodOperador(resultado.getLong("cod_operador"));

            }

           

        } catch (Exception e) {

            throw new RuntimeException("Error validando operador" + e);

        }

        return operadorEncontrado;

    }

}
