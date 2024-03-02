package com.edu.ec.repository.modelo.dto;

import java.time.LocalDate;

public class MatriculaDTO {
	
	private String cedulaEstudiante;
	private String codigoMateria;
	private LocalDate fecha;
	private String nombreHilo;
	
	
	public MatriculaDTO(String cedulaEstudiante, String codigoMateria, LocalDate fecha, String nombreHilo) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.codigoMateria = codigoMateria;
		this.fecha = fecha;
		this.nombreHilo = nombreHilo;
	}


	public MatriculaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}


	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}


	public String getCodigoMateria() {
		return codigoMateria;
	}


	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getNombreHilo() {
		return nombreHilo;
	}


	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}


	@Override
	public String toString() {
		return "MatriculoDTO [cedulaEstudiante=" + cedulaEstudiante + ", codigoMateria=" + codigoMateria + ", fecha="
				+ fecha + ", nombreHilo=" + nombreHilo + "]";
	}
	
	
	

}
