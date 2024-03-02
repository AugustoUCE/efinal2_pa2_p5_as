package com.edu.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.ec.repository.modelo.Estudiante;
import com.edu.ec.service.IEstudianteServ;


@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
	private IEstudianteServ estudianteServ;
	//http://localhost:8080
	
	@GetMapping("/nuevo")
	public String mostrarNuevoEstudiante(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		return "VNewEstudiante";
	}
	@PostMapping("/guardar")
	public String guardarEstudiante(Estudiante estudiante) {
		this.estudianteServ.guardar(estudiante);
		return "redirect:/estudiantes/nuevo";

	}
	

}
