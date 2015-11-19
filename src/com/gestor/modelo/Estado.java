/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestor.modelo;

/**
 *
 * @author Luis
 * 
 */
public class Estado {
    
    private long codigo;
    private String estado;
    
    
    

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    // CONSTRUCTOR
    
    
   
     public Estado(long codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
    }
     
      public Estado() {
 
    }
    
    // TO STRING
    @Override
    public String toString() {
        return "Estado{" + "codigo=" + codigo + ", estado=" + estado + '}';
    }
      
      
    
    
    
    
    
}
