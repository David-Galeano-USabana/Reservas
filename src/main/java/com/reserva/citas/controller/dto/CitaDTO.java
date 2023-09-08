package com.reserva.citas.controller.dto;

import lombok.Data;

import java.sql.Time;

public @Data
class CitaDTO {
    private int idCita;
    private String cliente;
    private Time fechaReserva;
    private int idEmpresa;
}
