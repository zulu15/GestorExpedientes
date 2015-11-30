package com.gestor.impl;

import com.gestor.daos.ExpedienteDAO;
import com.gestor.modelo.Expediente;
import com.gestor.util.Conexion;
import com.gestor.util.Fecha;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    @Override
    public List<Expediente> listarXfecha(Date fechaInicio, Date fechaFin) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Expediente> expedientes = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM expedientes WHERE fecha_hecho BETWEEN ? AND ?";
            pstm = conexion.prepareStatement(sql);
            pstm.setDate(1, Fecha.getCurrentDate(fechaInicio));
            pstm.setDate(2, Fecha.getCurrentDate(fechaFin));
            rs = pstm.executeQuery();
            Expediente expediente;
            while(rs.next()){
                expediente = new  Expediente();
                expediente.setNumeroExpediente(rs.getLong("nro_expte"));
                expediente.setIdPersona(rs.getLong("id_persona"));
                expediente.setFechaDenuncia(rs.getDate("fecha_denuncia"));
                expediente.setFechaHecho(rs.getDate("fecha_hecho"));
                expediente.setCodDelito(rs.getLong("cod_delito"));
                expediente.setDescripcion(rs.getString("descripcion"));
                expediente.setIdEstado(rs.getLong("id_estado"));
                expediente.setCodOperador(rs.getLong("cod_operador"));
                expedientes.add(expediente);
            
            }
            
            
        } catch (Exception e) {
            throw new RuntimeException("Error listando expedientes x fecha "+e);
        }
        
        
        return expedientes;
        
    }

   
   
    
     public static Date parseDate(String date) {
     try {
         return new SimpleDateFormat("yyyy-mm-dd").parse(date);
     } catch (ParseException e) {
         return null;
     }
  }
}
