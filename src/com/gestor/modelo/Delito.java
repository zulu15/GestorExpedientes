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
public class Delito {
    
    private long codDelito;
    private String caratula;
    
    //SETTERS Y GETTERS
    public long getCodDelito() {
        return codDelito;
    }

    public void setCodDelito(long codDelito) {
        this.codDelito = codDelito;
    }

    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }
    
    //  CONTRUCTOR
    
    public Delito(long codDelito, String caratula) {
        this.codDelito = codDelito;
        this.caratula = caratula;
    }
    
    
     public Delito() {
     
    }
    
    //TO STRING
     
    @Override
    public String toString() {
        return "Delito{" + "codDelito=" + codDelito + ", caratula=" + caratula + '}';
    }
     
     
}
