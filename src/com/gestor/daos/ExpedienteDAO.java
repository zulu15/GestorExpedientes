package com.gestor.daos;

import com.gestor.modelo.Expediente;
import java.util.Date;
import java.util.List;


public interface ExpedienteDAO {
    
    public void generarExpediente(Expediente expediente) throws Exception;
    public List<Expediente> listarXfecha(Date fechaInicio,Date fechaFin);
    
}
