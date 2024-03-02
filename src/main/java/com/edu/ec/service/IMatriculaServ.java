package com.edu.ec.service;

import java.util.List;

import com.edu.ec.repository.modelo.Matricula;
import com.edu.ec.repository.modelo.dto.MatriculaDTO;
import com.edu.ec.service.to.MatriculaTO;

public interface IMatriculaServ {
	public void guardar(Matricula matricula);
	public void matriculaCedulaCodigo(Matricula matricula,String cedula,String codigo);
	public void matriculaHiloParalelo(MatriculaTO matriculaTO);
	public List<MatriculaDTO> reporteMatriculas();
}
