package com.edu.ec.service;

import com.edu.ec.repository.modelo.Materia;

public interface IMateriaServ {
	public void guardar(Materia materia);
	public Materia buscarPorCodigo(String codigo);

	
}
