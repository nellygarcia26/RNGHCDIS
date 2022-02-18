package com.bancoRNGH.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import com.bancoRNGH.springboot.app.models.entity.Banco;


public class BancoDaoImpl implements IBancoDao {

	@PersistenceContext
	private EntityManager em;
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Banco> FindAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Banco").getResultList();
	}



	@Override
	@Transactional
	public void save(Banco banco) {
		
		if(banco.getId()!=null && banco.getId()> 0) {
		
			em.merge(banco);
	}else {
		em.persist(banco);
	}
	}
	
}
