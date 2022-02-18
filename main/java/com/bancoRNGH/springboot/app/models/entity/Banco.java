package com.bancoRNGH.springboot.app.models.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity                 
@Table(name="bancos")

public class Banco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@NotEmpty
	@Column(name="Nombre")
	private String nombre;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotEmpty
	@Column (name="Ubicacion")
	private String ubicacion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	

}
