package com.reserva.citas.persistencia;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;


@Entity
@Table
public @Data class Cita {

    @Id
    @Column(name = "idcita")
    private int idCita;
    @Column(name = "fechareserva")
    private LocalTime fechaReserva;

    @Column(name = "idempresa")
    private int idEmpresa;

    @Column(name = "cliente")
    private String cliente;



}
