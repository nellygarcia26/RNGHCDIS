package com.bancoRNGH.springboot.app.models.dao;

import java.util.List;

import com.bancoRNGH.springboot.app.models.entity.Tarjeta;

public interface ITarjetaDao {

	
public List<Tarjeta>FindAll();
	
	public void save(Tarjeta tarjeta);
	
public Tarjeta findOne(Long id);

//Busqueda//
public List<Tarjeta> findByCuentaId(String term);

	/*ELIMINAR TARJETA*/
	public void delete(Long id);
	
	public Tarjeta findByNumerotarjeta(String Numerotarjeta);
	
	public List<Tarjeta> findByIdCuenta(Long idCuenta);
}

