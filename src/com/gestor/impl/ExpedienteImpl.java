/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.impl;

import com.gestor.daos.ExpedienteDAO;
import com.gestor.modelo.Expediente;
import com.gestor.util.Conexion;
import com.gestor.util.Fecha;
import java.sql.Connection;


import java.sql.PreparedStatement;


public class ExpedienteImpl implements ExpedienteDAO{

    @Override
    public void generarExpediente(Expediente expediente) throws Exception{
        
        try {

            Connection conexion = Conexion.getConexion();
            String sql = "INSERT INTO expedientes (nro_expte, id_persona, fecha_denuncia, fecha_hecho, cod_delito, descripcion, id_estado, cod_operador) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conexion.prepareStatement(sql);
            
            pstm.setLong(1, 0);
            pstm.setLong(2, expediente.getIdPersona());
            pstm.setDate(3, Fecha.getCurrentDate());
            pstm.setDate(4, expediente.getFechaHecho());
            pstm.setLong(5, expediente.getCodDelito());
            pstm.setString(6, expediente.getDescripcion());
            pstm.setLong(7, expediente.getIdEstado());
            pstm.setLong(8, expediente.getCodOperador());
            
            
            int resultado = pstm.executeUpdate();
            System.out.println("Registros afectados "+resultado);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error " + e);

        }
    }

    
}
