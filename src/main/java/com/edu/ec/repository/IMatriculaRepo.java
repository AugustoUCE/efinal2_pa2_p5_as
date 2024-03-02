package com.edu.ec.repository;

import java.util.List;

import com.edu.ec.repository.modelo.Matricula;
import com.edu.ec.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaRepo {
	public void insertar(Matricula matricula);
	public List<MatriculaDTO> reporteMatriculas();

}
