package com.reserva.citas.controller;

import com.reserva.citas.controller.dto.CitaDTO;
import com.reserva.citas.controller.dto.RespuestaDTO;
import com.reserva.citas.logica.CitaLogica;
import com.reserva.citas.persistencia.Cita;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CitaController {
    private CitaLogica citaLogica;
    List<Cita> citas = new ArrayList<>();

    public CitaController(CitaLogica citaLogica) {
        this.citaLogica = citaLogica;
    }

    @PostMapping(path = "/citas/crear")
    public RespuestaDTO subirCita(@RequestBody CitaDTO citaDTO) {

        citaLogica.crearCita(citaDTO);
        return new RespuestaDTO();
    }
}
