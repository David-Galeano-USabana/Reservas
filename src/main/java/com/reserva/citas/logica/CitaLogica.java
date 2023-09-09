package com.reserva.citas.logica;

import com.reserva.citas.controller.dto.CitaDTO;
import com.reserva.citas.persistencia.Cita;
import com.reserva.citas.persistencia.CitaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Optional;

@Service
public class CitaLogica {

    private CitaRepository citaRepository;

    public CitaLogica(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public void crearCita(CitaDTO citaDTO) {
        Cita cita = new Cita();
        cita.setIdCita(citaDTO.getIdCita()); //A utilizar un código automatico
        cita.setFechaReserva(LocalTime.parse(citaDTO.getFechaReserva()));
        cita.setCliente(citaDTO.getCliente());
        cita.setIdEmpresa(citaDTO.getIdEmpresa());
        citaRepository.save(cita);
    }

    public Optional<Cita> obtenerReserva(int id) {
        return citaRepository.findById(id);
    }
    public void cancelarCitaPorId(int id){
        citaRepository.deleteById(id);
    }
}
