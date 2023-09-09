package com.reserva.citas.persistencia;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;


@Entity
@Table
public @Data class Cita {

    @Id
    @Column(name = "idCita")
    private int idCita;
    @Column
    private Time fechaReserva;

    @Column
    private String empresa;

    @Column(name = "cliente")
    private String cliente;



}
