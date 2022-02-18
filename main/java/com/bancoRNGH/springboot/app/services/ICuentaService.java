package com.bancoRNGH.springboot.app.services;

import java.util.List;

import com.bancoRNGH.springboot.app.models.entity.Cuenta;

public interface ICuentaService {

	public Cuenta getById(Long id, List<Cuenta> lista);
	
}
