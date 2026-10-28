package com.gremio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gremio.model.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    // No necesitas escribir nada aquí
    // Spring Data JPA genera save(), findAll(), findById(), deleteById() automáticamente
}