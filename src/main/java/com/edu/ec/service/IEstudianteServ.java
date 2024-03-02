package com.edu.ec.service;

import com.edu.ec.repository.modelo.Estudiante;

public interface IEstudianteServ {
	public void guardar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante buscarPorCedula(String cedula);

}
