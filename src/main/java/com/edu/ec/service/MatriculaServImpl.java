package com.edu.ec.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.repository.IEstudianteRepo;
import com.edu.ec.repository.IMateriaRepo;
import com.edu.ec.repository.IMatriculaRepo;
import com.edu.ec.repository.modelo.Estudiante;
import com.edu.ec.repository.modelo.Materia;
import com.edu.ec.repository.modelo.Matricula;
import com.edu.ec.repository.modelo.dto.MatriculaDTO;
import com.edu.ec.service.to.MatriculaTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServImpl implements IMatriculaServ {

	@Autowired
	private IMatriculaRepo matriculaRepo;
	@Autowired
	private IEstudianteRepo estudianteRepo;
	@Autowired
	private IMateriaRepo materiaRepo;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRepo.insertar(matricula);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matriculaCedulaCodigo(Matricula matricula,String cedula, String codigo) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.estudianteRepo.seleccionarPorCedula(cedula);
		Materia materia = this.materiaRepo.buscarPorCodigo(codigo);
		
		matricula.setEstudiante(estudiante);
		matricula.setMateria(materia);
		matricula.setFecha(LocalDate.now());
		this.matriculaRepo.insertar(matricula);
		
	}
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matriculaHiloParalelo(MatriculaTO matriculaTO) {
		// TODO Auto-generated method stub
		Matricula matr1 = new Matricula();
		matr1.setFecha(LocalDate.now());
		Materia ma1 = new Materia();
		ma1.setCodigo(matriculaTO.getCodigoMateria1());
		matr1.setMateria(ma1);
		
		Matricula matr2 = new Matricula();
		matr2.setFecha(LocalDate.now());
		Materia ma2 = new Materia();
		ma2.setCodigo(matriculaTO.getCodigoMateria2());
		matr2.setMateria(ma2);
		
		Matricula matr3 = new Matricula();
		matr3.setFecha(LocalDate.now());
		Materia ma3 = new Materia();
		ma3.setCodigo(matriculaTO.getCodigoMateria3());
		matr3.setMateria(ma3);
		
		Matricula matr4 = new Matricula();
		matr4.setFecha(LocalDate.now());
		Materia ma4 = new Materia();
		ma4.setCodigo(matriculaTO.getCodigoMateria4());
		matr4.setMateria(ma4);
		
		List<Matricula> matriculas = new ArrayList<>();

		matriculas.add(matr1);
		matriculas.add(matr2);
		matriculas.add(matr3);
		matriculas.add(matr4);
		

		for (Matricula matricula : matriculas) {
		    String hilo = Thread.currentThread().getName();
		    matricula.setNombreHilo(hilo);
		    matriculaCedulaCodigo(matricula,matriculaTO.getCedulaEstudiante(), matricula.getMateria().getCodigo());
		}


	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<MatriculaDTO> reporteMatriculas() {
		// TODO Auto-generated method stub
		return this.matriculaRepo.reporteMatriculas();
	}
}
