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
    private int idCita;
    @Column
    private Time fecha;

    @Column
    private String empresa;

    @Column
    private String cliente;



}
