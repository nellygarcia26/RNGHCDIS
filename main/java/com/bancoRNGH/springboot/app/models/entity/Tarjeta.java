package com.bancoRNGH.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "tarjetas")
public class Tarjeta implements Serializable {

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private Long id;
	

     @NotEmpty
     @Column(name = "numero_tarjeta", nullable = false, length = 16)
	private String numeroTarjeta;
     
     @NotEmpty
     @Column(name = "icv", nullable = false, length = 3)
     private String cv;
	
     @NotEmpty
     @Column(name = "tipo_tarjeta")
     private String tipoTarjeta;
     
     @Column(name = "vencimiento")
     @Temporal(TemporalType.DATE)
 	@DateTimeFormat(pattern="yyyy-MM-dd")
     private Date vencimiento;
     
     
    @JoinColumn(name= "cuenta", referencedColumnName = "id", nullable=false )
    @ManyToOne(optional=false, fetch= FetchType.LAZY)
    private Cuenta cuenta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
