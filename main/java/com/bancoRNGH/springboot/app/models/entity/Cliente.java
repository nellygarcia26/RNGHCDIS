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
@Table(name="clientes")

public class Cliente implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@NotEmpty
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private Long id_cliente;
	
	@NotEmpty
	@Column(name="nombre")
     private String nombre;
	
@NotEmpty
@Column(name="Apellido")
private String apellido;

@NotEmpty
@Column(name= "numero_telefono")
private String numeroTelefono;
	
  @NotEmpty
  @Column(name="Email")
  private String email;
  
  @Column(name="idcuenta")
	@Id
	@NotEmpty
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private Long id_cuenta;

public Long getId_cliente() {
	return id_cliente;
}

public void setId_cliente(Long id_cliente) {
	this.id_cliente = id_cliente;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getNumeroTelefono() {
	return numeroTelefono;
}

public void setNumeroTelefono(String numeroTelefono) {
	this.numeroTelefono = numeroTelefono;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Long getId_cuenta() {
	return id_cuenta;
}

public void setId_cuenta(Long id_cuenta) {
	this.id_cuenta = id_cuenta;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

  
  
}
