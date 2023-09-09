package com.reserva.citas.controller.dto;

import lombok.Data;

public @Data
class CitaDTO {
    private int idCita;
    private String cliente;
    private String fechaReserva;
    private int idEmpresa;
}
