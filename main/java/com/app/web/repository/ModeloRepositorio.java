package com.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Modelo;



@Repository
public interface ModeloRepositorio extends JpaRepository<Modelo, Long>{

	
}
