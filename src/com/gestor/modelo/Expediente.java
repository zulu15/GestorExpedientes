/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestor.modelo;

import java.sql.Date;


public class Expediente {
    
    private long numeroExpediente, idPersona, codDelito, idEstado,codOperador;
    private Date fechaDenuncia, fechaHecho;
    
    private String descripcion;
    
    //GETTERS SETTERS, CONSTRUCTOR SOBRECARGADO, CONTRUCTOR VACÍO, TOSTRING(PARA MOSTRAR EL OBJETO)
    
    
    //GETTERS Y SETTERS 
    
    
    public long getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(long numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public long getCodDelito() {
        return codDelito;
    }

    public void setCodDelito(long codDelito) {
        this.codDelito = codDelito;
    }

    public long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(long idEstado) {
        this.idEstado = idEstado;
    }

    public long getCodOperador() {
        return codOperador;
    }

    public void setCodOperador(long codOperador) {
        this.codOperador = codOperador;
    }

    public Date getFechaDenuncia() {
        return fechaDenuncia;
    }

    public void setFechaDenuncia(Date fechaDenuncia) {
        this.fechaDenuncia = fechaDenuncia;
    }

    public Date getFechaHecho() {
        return fechaHecho;
    }

    public void setFechaHecho(Date fechaHecho) {
        this.fechaHecho = fechaHecho;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //CONTRUCTOR SOBRECARGADO
    
    
    public Expediente(long numeroExpediente, long idPersona, long codDelito, long idEstado, long codOperador, Date fechaDenuncia, Date fechaHecho, String descripcion) {
        this.numeroExpediente = numeroExpediente;
        this.idPersona = idPersona;
        this.codDelito = codDelito;
        this.idEstado = idEstado;
        this.codOperador = codOperador;
        this.fechaDenuncia = fechaDenuncia;
        this.fechaHecho = fechaHecho;
        this.descripcion = descripcion;
    }
    
      public Expediente (){
      
      }
      
    // TO STRING
      
    @Override
    public String toString() {
        return "Expediente{" + "numeroExpediente=" + numeroExpediente + ", idPersona=" + idPersona + ", codDelito=" + codDelito + ", idEstado=" + idEstado + ", codOperador=" + codOperador + ", fechaDenuncia=" + fechaDenuncia + ", fechaHecho=" + fechaHecho + ", descripcion=" + descripcion + '}';
    }
        
    
        
    
    
    
}
