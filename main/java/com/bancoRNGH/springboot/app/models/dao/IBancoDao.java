package com.bancoRNGH.springboot.app.models.dao;

import java.util.List;

import com.bancoRNGH.springboot.app.models.entity.Banco;

public interface IBancoDao {
	
public List<Banco>FindAll();
	
	public void save(Banco banco);

}
