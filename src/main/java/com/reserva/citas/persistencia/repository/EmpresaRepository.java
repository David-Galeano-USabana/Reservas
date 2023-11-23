package com.reserva.citas.persistencia.repository;

import com.reserva.citas.persistencia.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
