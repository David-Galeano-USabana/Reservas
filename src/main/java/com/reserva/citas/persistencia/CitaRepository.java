package com.reserva.citas.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
}
