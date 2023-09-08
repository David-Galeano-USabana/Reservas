package com.reserva.citas.logica;

import com.reserva.citas.controller.dto.CitaDTO;
import com.reserva.citas.persistencia.Cita;
import com.reserva.citas.persistencia.CitaRepository;

public class CitaLogica {
    private CitaRepository citaRepository;

    public CitaLogica(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public void crearCita(CitaDTO citaDTO){

        Cita cita = new Cita();
        citaRepository.save(cita);
    }
}
