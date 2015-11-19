/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestor.modelo;

/**
 *
 * @author Luis
 */
public class Operador {
    
    private String  usuario, clave;
    private long codOperador;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public long getCodOperador() {
        return codOperador;
    }

    public void setCodOperador(long codOperador) {
        this.codOperador = codOperador;
    }
    
    
    
    

    public Operador(long codOperador,String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
        this.codOperador = codOperador;
    }
    
    public Operador() {
       
    }

    @Override
    public String toString() {
        return "Operador{" + "usuario=" + usuario + ", clave=" + clave + ", codOperador=" + codOperador + '}';
    }
    
    
    
    
    
    
    
    
    
}
