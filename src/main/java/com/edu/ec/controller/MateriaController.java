package com.edu.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.ec.repository.modelo.Materia;
import com.edu.ec.service.IMateriaServ;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	@Autowired
	private IMateriaServ materiaServ;
	
	@GetMapping("/nuevo")
	public String mostrarNuevo(Model model) {
		model.addAttribute("materia", new Materia());
		return "VNewMateria";
	}
	
	@PostMapping("/guardar")
	public String nuevaMateria(Materia materia) {
		//TODO: process POST request
		this.materiaServ.guardar(materia);
		
		return "redirect:/materias/nuevo";
	}

}
