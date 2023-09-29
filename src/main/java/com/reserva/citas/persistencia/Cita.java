package com.reserva.citas.persistencia;

import lombok.Data;

import javax.lang.model.element.Name;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;


@Entity
@Table(name = "Citas")
public @Data class Cita {

    @Id
    @Column(name = "idcita")
    private int idCita;
    @Column(name = "fechareserva")
    private Time fechaReserva;

    @Column(name = "idempresa")
    private int idEmpresa;

    @Column(name = "cliente")
    private String cliente;



}
