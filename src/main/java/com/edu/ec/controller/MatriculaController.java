package com.edu.ec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.ec.repository.modelo.dto.MatriculaDTO;
import com.edu.ec.service.IMatriculaServ;
import com.edu.ec.service.to.MatriculaTO;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private IMatriculaServ matriculaServ;
	
	
	@GetMapping("/nuevo")
	public String mostrarNuevoMatricula(Model model) {
		model.addAttribute("matriculaTO", new MatriculaTO());
		return "VNewMatricula";
	}

	@PostMapping("/guardar")
	public String guardarMatricula(MatriculaTO matriculaTO) {
		this.matriculaServ.matriculaHiloParalelo(matriculaTO);
		return "redirect:/matriculas/nuevo";
	}
	
	@GetMapping("/reporte")
	public String reporte(MatriculaDTO matriculaDTO, Model model) {
		List<MatriculaDTO> list= this.matriculaServ.reporteMatriculas();
		model.addAttribute("reporte", list);
		return "VReporteMatricula";
	}
	
	
}
