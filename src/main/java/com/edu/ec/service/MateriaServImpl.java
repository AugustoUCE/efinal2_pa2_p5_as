package com.edu.ec.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.repository.IMateriaRepo;
import com.edu.ec.repository.modelo.Materia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MateriaServImpl implements IMateriaServ {
	@Autowired
	private IMateriaRepo materiaRepo;

	

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepo.insertar(materia);
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.materiaRepo.buscarPorCodigo(codigo);
	}




	
	

}
