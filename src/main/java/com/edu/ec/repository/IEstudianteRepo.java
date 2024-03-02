package com.edu.ec.repository;

import com.edu.ec.repository.modelo.Estudiante;

public interface IEstudianteRepo {
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante seleccionarPorCedula(String cedula);

}
