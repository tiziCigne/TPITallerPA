package com.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
