/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.impl;

import com.gestor.daos.DelitoDAO;
import com.gestor.modelo.Delito;
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
public class DelitoImpl implements DelitoDAO{

    @Override
    public List<Delito> listarDelitos() {
    Vector<Delito> listarDelitos = new Vector();
        try {

            Connection conexion = Conexion.getConexion();
            String sql = "SELECT * FROM delitos";
            PreparedStatement pstm = conexion.prepareStatement(sql);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {
                Delito delito = new Delito();
                
                delito.setCodDelito(resultado.getLong("cod_delito"));
                delito.setCaratula(resultado.getString("caratula"));
                listarDelitos.add(delito);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error " + e);

        }

        return listarDelitos;     
    }
    
}
