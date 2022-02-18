package com.bancoRNGH.springboot.app.models.dao;

import java.util.List;

import com.bancoRNGH.springboot.app.models.entity.Cuenta;


public interface ICuentaDao {
	
	public List<Cuenta>FindAll();
	
	public void save(Cuenta cuenta);

	public Cuenta findOne(Long id);
	
	public void detelete(Long id);
	}
