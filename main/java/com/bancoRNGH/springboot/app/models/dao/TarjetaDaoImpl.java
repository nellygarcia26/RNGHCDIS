package com.bancoRNGH.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;


import com.bancoRNGH.springboot.app.models.entity.Tarjeta;

@Repository
public class TarjetaDaoImpl implements ITarjetaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly= true)
	@Override
	public List<Tarjeta> FindAll() {
		return em.createQuery("from Tarjeta").getResultList();

}
	@Override
	@Transactional
	public void save(Tarjeta tarjeta) {
		
		if(tarjeta.getId()!=null && tarjeta.getId()> 0) {
		
			em.merge(tarjeta);
	}else {
		em.persist(tarjeta);
	}
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public Tarjeta findOne(Long id) {
		return em.find(Tarjeta.class, id);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}

	@Transactional(readOnly=true)
	@Override
	public Tarjeta findByNumerotarjeta(String Numerotarjeta) {
		
		List<Tarjeta> listaTarjetas = this.FindAll();
		Tarjeta tarjetaResult = null;
		
		for(Tarjeta tarjeta: listaTarjetas) {
			if(tarjeta.getNumeroTarjeta().equals(Numerotarjeta)) {
				tarjetaResult = tarjeta;
			}
		}
		
		return tarjetaResult;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Tarjeta> findByIdCuenta(Long idCuenta) {
		
		List<Tarjeta> listaTarjeta = this.FindAll();
		List<Tarjeta> result = new ArrayList<Tarjeta>();
		
		for(Tarjeta tarjeta: listaTarjeta) {
			
			if(tarjeta.getCuenta().getId() == idCuenta) {
				result.add(tarjeta);
			}
			
		}
		
		return result;
	}
	
	@Override
	public List<Tarjeta> findByCuentaId(String term) {
		// TODO Auto-generated method stub
		return null;
	}
}