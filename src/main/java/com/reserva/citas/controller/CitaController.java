package com.reserva.citas.controller;

import com.reserva.citas.controller.dto.CitaDTO;
import com.reserva.citas.controller.dto.RespuestaDTO;
import com.reserva.citas.logica.CitaLogica;
import com.reserva.citas.persistencia.Cita;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CitaController {
    private CitaLogica citaLogica;

    public CitaController(CitaLogica citaLogica) {
        this.citaLogica = citaLogica;
    }

    @PostMapping(path = "/citas/crear")
    public RespuestaDTO subirCita(@RequestBody CitaDTO citaDTO) {

        citaLogica.crearCita(citaDTO);
        return new RespuestaDTO("Cita creada exitosamente. Tu ID de cita es: "+ citaDTO.getIdCita());
    }
    @GetMapping(path = "/citas")
    public List<Cita> buscarCitas(){
        return citaLogica.obtenerReservas();
    }


}
