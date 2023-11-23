package com.reserva.citas.logica;

import com.reserva.citas.controller.dto.CitaDTO;
import com.reserva.citas.persistencia.Cita;
import com.reserva.citas.persistencia.repository.CitaRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import java.sql.Time;
import java.util.Optional;

@Service
public class CitaLogica {

    private CitaRepository citaRepository;

    public CitaLogica(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public Cita crearCita(CitaDTO citaDTO) {

        if (fechaOcupada(citaDTO)) {
            throw new IllegalArgumentException("No es posible tener dos citas en la misma fecha");
        }
        Cita cita = new Cita();
        cita.setIdCita(citaDTO.getIdCita());
        cita.setFechaReserva(Time.valueOf(citaDTO.getFechaReserva()));
        cita.setCliente(citaDTO.getCliente());
        cita.setIdEmpresa(citaDTO.getIdEmpresa());
        cita.setEstado(true);
        citaRepository.save(cita);
        return cita;
    }

    public Optional<Cita> obtenerReservaPorId(int id) {
        return citaRepository.findById(id);
    }

    public void cancelarCitaPorId(int id) {
        Optional<Cita> cita = citaRepository.findById(id);
        if(cita.isPresent()) {
            Cita mod = cita.get();
            mod.setEstado(false);
            citaRepository.save(mod);
        }
        else{
            throw new IllegalArgumentException("No existe tal cita");
        }
    }

    private boolean fechaOcupada(CitaDTO citaDTO) {
        Cita cita = new Cita();
        cita.setFechaReserva(Time.valueOf(citaDTO.getFechaReserva()));
        cita.setEstado(true);
        Example<Cita> example = Example.of(cita);
        Optional<Cita> match = citaRepository.findOne(example);
        return match.isPresent();
    }

    public boolean disponibilidad(String fecha) {
        Cita cita = new Cita();
        cita.setFechaReserva(Time.valueOf(fecha));
        Example<Cita> example = Example.of(cita);
        Optional<Cita> match = citaRepository.findOne(example);
        return match.isPresent();
    }
}
