/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestor.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Luis
 */
public class Conexion {
    
    //declaramos las consantes para la conexion
    
    private static final String USUARIO_CONEXION="root";
    private static final String PASSWORD_CONEXION="";
    private static final String URL_CONEXION="jdbc:mysql://localhost/gestor_judicial";
    private static final String DRIVER_CONEXION ="com.mysql.jdbc.Driver";
    
    //declaramos la variabla de tipo conexion
    //para ahorrar recursos se creara siempre una sola instnacia
    private static Connection conexion;

    
    //este metodo devuelve la conexion
    public static Connection getConexion() {
        
        if (conexion== null){
        
        //creamos la conexion
            //levantamos el driver a la onexion
            
            try{
            
            Class.forName(DRIVER_CONEXION);
            
            
            conexion =DriverManager.getConnection(URL_CONEXION, USUARIO_CONEXION, PASSWORD_CONEXION);
             System.out.println("Conexion levantada de manera exitosa");
            } catch (Exception e ){
            
                System.err.print("Error conectandose a la base de datos "+e);
                throw new RuntimeException(e);
            }
        
        
        }
        return conexion;
    }
    
    public static void main (String[] args){
        
        //le pedimos a la clase quelevante la conexion y la pasea  a nuestra variable
    Connection conexion =Conexion.getConexion();
    
    }
    
}
