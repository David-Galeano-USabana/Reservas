package com.reserva.citas.logica;

import com.reserva.citas.controller.dto.CitaDTO;
import com.reserva.citas.persistencia.Cita;
import com.reserva.citas.persistencia.CitaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles(profiles = "test")
class CitaLogicaTest {

    @InjectMocks
    CitaLogica citaLogica;
    @Mock
    CitaRepository citaRepository;


    @Test
    void Given_a_cita_When_invoke_crearcita_Then_return_true() {
        int id = 5;
        CitaDTO citaDTO = new CitaDTO();
        citaDTO.setIdCita(id);
        citaDTO.setCliente("John Ramon Pikmin Rise III");
        citaDTO.setFechaReserva("10:00:00");
        citaDTO.setIdEmpresa(3);
        Cita cita = citaLogica.crearCita(citaDTO);
        Mockito.verify(citaRepository).save(cita);
    }

    @Test
    void Given_a_cita_When_invoke_obtenerreservaporid_Then_return_true() {
        int id = 5;
        citaLogica.obtenerReservaPorId(id);
        Mockito.verify(citaRepository).findById(id);
    }

    @Test
    void Given_a_cita_When_invoke_cancelarCitaPorId_Then_return_true() {
        int id = 5;
        CitaDTO citaDTO = new CitaDTO();
        citaDTO.setIdCita(id);
        citaDTO.setCliente("John Ramon Pikmin Rise III");
        citaDTO.setFechaReserva("10:00:00");
        citaDTO.setIdEmpresa(3);
        Cita cita = citaLogica.crearCita(citaDTO);
        cita.setEstado(false);
        citaLogica.cancelarCitaPorId(id);
        Mockito.verify(citaRepository).findById(id);
    }
}