package com.edu.ec.repository;

import com.edu.ec.repository.modelo.Materia;

public interface IMateriaRepo {

	public void insertar(Materia materia);
	public Materia buscarPorCodigo(String codigo);
}
