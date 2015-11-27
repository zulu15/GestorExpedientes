package com.gestor.daos;

import com.gestor.modelo.Persona;
import java.util.List;


public interface PersonaDAO {

    public List<Persona> listar();

	public void eliminar(long id) throws Exception;

	public void actualizar(Persona persona) throws Exception;

	public void insertar(Persona persona) throws Exception;
    
    
}
