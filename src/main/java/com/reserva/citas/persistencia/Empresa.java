package com.reserva.citas.persistencia;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public @Data class Empresa {

    @Id
    @Column
    private int idEmpresa;
    @Column
    private String nombre;

}
