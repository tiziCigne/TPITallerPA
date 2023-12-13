package com.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.tecnico;

@Repository 
public interface tecnicoRepositorio extends JpaRepository<tecnico, Long>{

}
