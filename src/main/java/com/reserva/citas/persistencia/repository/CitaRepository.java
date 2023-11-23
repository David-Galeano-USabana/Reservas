package com.reserva.citas.persistencia.repository;

import com.reserva.citas.persistencia.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
}
