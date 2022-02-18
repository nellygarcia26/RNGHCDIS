package com.bancoRNGH.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import com.bancoRNGH.springboot.app.models.entity.Empleado;

public class EmpleadoDaoImpl implements IEmpleadoDao {

	@PersistenceContext
	private EntityManager em;
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Empleado>FindAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Empleado").getResultList();
	}



	@Override
	@Transactional
	public void save(Empleado empleado) {
		
		if(empleado.getId()!=null && empleado.getId()> 0) {
		
			em.merge(empleado);
	}else {
		em.persist(empleado);
		
	}
	}



	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Transactional
	@Override
	public Empleado findOne(Long id) {
		return em.find(Empleado.class, id);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}

		
}
