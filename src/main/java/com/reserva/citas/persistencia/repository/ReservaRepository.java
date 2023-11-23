package com.reserva.citas.persistencia.repository;

import com.reserva.citas.persistencia.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
