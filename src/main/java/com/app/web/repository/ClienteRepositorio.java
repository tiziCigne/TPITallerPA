package com.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Cliente;

/**
 * Interfaz que define un repositorio JPA para la entidad Cliente.
 *
 * La interfaz extiende JpaRepository para aprovechar las capacidades de Spring Data JPA
 * para realizar operaciones CRUD en la entidad Cliente.
 */

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
	/** No se necesitan métodos adicionales aquí, ya que JpaRepository proporciona
    *automáticamente métodos para realizar operaciones CRUD en la entidad Cliente.
    * Estos métodos incluyen findAll(), findById(), save(), deleteById(), etc.
	**/
}