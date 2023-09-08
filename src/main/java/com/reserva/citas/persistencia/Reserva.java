package com.reserva.citas.persistencia;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public @Data class Reserva {
    @Id
    @Column
    private int idReserva;
    @Column
    private String servicio;

}
