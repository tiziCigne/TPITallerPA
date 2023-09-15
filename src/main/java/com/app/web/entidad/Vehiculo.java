package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table

public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "patente", nullable = false, length = 50, unique=true)
	private String patente;
	public Vehiculo() {
		
	}

	public Vehiculo(String patente) {
		super();
		this.patente = patente;
	}

	public Vehiculo(Long id, String patente) {
		super();
		this.id = id;
		this.patente = patente;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", patente=" + patente + "]";
	}
	
	
}
