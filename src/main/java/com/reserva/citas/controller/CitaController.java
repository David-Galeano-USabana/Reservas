package com.reserva.citas.controller;

import com.reserva.citas.controller.dto.CitaDTO;
import com.reserva.citas.controller.dto.RespuestaDTO;
import com.reserva.citas.logica.CitaLogica;
import com.reserva.citas.persistencia.Cita;
import com.reserva.citas.persistencia.CitaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CitaController {
    private CitaLogica citaLogica;
    private CitaRepository citaRepository;

    public CitaController(CitaLogica citaLogica) {
        this.citaLogica = citaLogica;
    }

    @PostMapping(path = "/citas/crear")
    public RespuestaDTO crearCita(@RequestBody CitaDTO citaDTO) {

        citaLogica.crearCita(citaDTO);
        return new RespuestaDTO("Cita creada exitosamente. Tu ID de cita es: " + citaDTO.getIdCita());
    }

    @GetMapping(path = "/citas/obtenerCita/{idCita}")
    public Optional<Cita> buscarCitas(@PathVariable int idCita) {
        return citaLogica.obtenerReservaPorId(idCita);
    }

    @GetMapping(path = "/citas/disponibilidad/{fechaCita}")
    public RespuestaDTO verificarDisponibilidad(@PathVariable String fechaCita) {
        if (citaLogica.disponibilidad(fechaCita)) {
            return new RespuestaDTO("No hay disponibilidad para esta fecha");
        } else {
            return new RespuestaDTO("Esta fecha está disponible");
        }
    }

    @PutMapping(path = "/citas/cancelar/{idCita}")
    public RespuestaDTO cancelarCita(@PathVariable int idCita) {
        citaLogica.cancelarCitaPorId(idCita);
        return new RespuestaDTO("Cita cancelada correctamente");
    }

}
