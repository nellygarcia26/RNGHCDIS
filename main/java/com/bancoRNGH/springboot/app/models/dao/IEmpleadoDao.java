package com.bancoRNGH.springboot.app.models.dao;

import java.util.List;

import com.bancoRNGH.springboot.app.models.entity.Empleado;

public interface IEmpleadoDao {


public List<Empleado>findAll();
	
	public void save(Empleado empleado);
	
	public Empleado findOne(Long id);
	
	public void delete(Long id);

	List<Empleado>FindAll();


	
}
