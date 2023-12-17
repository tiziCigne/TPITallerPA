package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity 
@Table(name = "tecnico")
public class tecnico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Apellido", nullable=false, length = 50)
	private String Apellido;
	
	@Column(name = "Nombre", nullable=false, length = 50)
	private String Nombre;
	
	
	@Column(name = "Telefono", nullable=false, length = 100	, unique = true)
	private int Telefono;
	
	
	public tecnico() {
		
	}

	public tecnico(Long id, String apellido, String nombre, int telefono) {
		super();
		this.id = id;
		Apellido = apellido;
		Nombre = nombre;
		Telefono = telefono;
	}
	public tecnico(String apellido, String nombre, int telefono) {
		super();
		Apellido = apellido;
		Nombre = nombre;
		Telefono = telefono;
	}

	@Override
	public String toString() {
		return "tecnico [id=" + id + ", Apellido=" + Apellido + ", Nombre=" + Nombre + ", Telefono=" + Telefono
				+ ", getId()=" + getId() + ", getApellido()=" + getApellido() + ", getNombre()=" + getNombre()
				+ ", getTelefono()=" + getTelefono() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getApellido() {
		return Apellido;
	}


	public void setApellido(String apellido) {
		Apellido = apellido;
	}


	public String getNombre() {
		return Nombre;
	}	


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public int getTelefono() {
		return Telefono;
	}


	public void setTelefono(int telefono) {
		Telefono = telefono;
	}


}
