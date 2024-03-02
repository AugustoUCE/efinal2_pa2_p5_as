package com.edu.ec.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.ec.repository.modelo.Matricula;
import com.edu.ec.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Repository
@Transactional
public class MatriculaRepoImpl implements IMatriculaRepo {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> reporteMatriculas() {
		// TODO Auto-generated method stub
		String jpql="SELECT NEW  com.edu.ec.repository.modelo.dto.MatriculaDTO(m.estudiante.cedula,m.materia.codigo,m.fecha,m.nombreHilo) FROM Matricula m ";
		TypedQuery<MatriculaDTO> myQuery=this.entityManager.createQuery(jpql,MatriculaDTO.class);
		return myQuery.getResultList();
	}
	
	

}
