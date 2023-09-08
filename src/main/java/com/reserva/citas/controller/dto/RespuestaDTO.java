package com.reserva.citas.controller.dto;

import lombok.Data;

public @Data class RespuestaDTO {
    String mensaje;

    public RespuestaDTO(String mensaje) {
        this.mensaje = mensaje;
    }
    public RespuestaDTO(){}
}
