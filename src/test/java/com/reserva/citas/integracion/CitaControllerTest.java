package com.reserva.citas.integracion;

import com.reserva.citas.controller.dto.CitaDTO;
import com.reserva.citas.controller.dto.RespuestaDTO;
import com.reserva.citas.logica.CitaLogica;
import com.reserva.citas.persistencia.Cita;
import com.reserva.citas.persistencia.repository.CitaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
class CitaControllerTest {
    @Autowired
    TestRestTemplate rest;
    @Autowired
    CitaRepository citaRepository;

    @Test
    void Dado_una_citadto_Cuando_invoque_crearcita_Entonces_retorna_respuestadto() {
        int id = 6;
        CitaDTO citaDTO = new CitaDTO();
        citaDTO.setIdCita(id);
        citaDTO.setCliente("John Ramon Pikmin Rise IV");
        citaDTO.setFechaReserva("12:00:00");
        citaDTO.setIdEmpresa(3);
        ResponseEntity<RespuestaDTO> response = rest.postForEntity("/citas/crear", citaDTO, RespuestaDTO.class);
        assertEquals("Cita creada exitosamente. Tu ID de cita es: " + citaDTO.getIdCita(), response.getBody().getMensaje());
    }

    @Test
    @Transactional
    void Dado_un_id_Cuando_invoca_obtenercita_Entonces_retorna_una_cita() {
        int id = 6;
        CitaDTO citaDTO = new CitaDTO();
        citaDTO.setIdCita(id);
        citaDTO.setCliente("John Ramon Pikmin Rise IV");
        citaDTO.setFechaReserva("12:00:00");
        citaDTO.setIdEmpresa(3);
        Cita cita = new Cita();

        cita.setIdCita(citaDTO.getIdCita());
        cita.setFechaReserva(Time.valueOf(citaDTO.getFechaReserva()));
        cita.setCliente(citaDTO.getCliente());
        cita.setIdEmpresa(citaDTO.getIdEmpresa());
        cita.setEstado(true);
        citaRepository.save(cita);
        ResponseEntity<Cita> response = rest.getForEntity("/citas/crear/", Cita.class, id);
        assertEquals(cita.getClass(), response.getBody().getClass());
    }

    @Test
    void Dado_id_Cuando_cancelar_Entonces_estado_falso() {
        int id = 6;
        CitaDTO citaDTO = new CitaDTO();
        citaDTO.setIdCita(id);
        citaDTO.setCliente("John Ramon Pikmin Rise IV");
        citaDTO.setFechaReserva("12:00:00");
        citaDTO.setIdEmpresa(3);
        Cita cita = new Cita();

        cita.setIdCita(citaDTO.getIdCita());
        cita.setFechaReserva(Time.valueOf(citaDTO.getFechaReserva()));
        cita.setCliente(citaDTO.getCliente());
        cita.setIdEmpresa(citaDTO.getIdEmpresa());
        cita.setEstado(true);
        citaRepository.save(cita);
        rest.put("/citas/cancelarCita/", Cita.class, id);
        Cita actual = citaRepository.findById(id).get();
        assertEquals(cita, actual);
    }
    @Test
    @Transactional
    void Dado_fecha_Cuando_verificardisponibilidad_Entonces_respuestadto_falso(){

        ResponseEntity<RespuestaDTO> response = rest.getForEntity("/citas/disponibilidad/", RespuestaDTO.class, "12:00:00");
        assertEquals(RespuestaDTO.class, response.getBody().getClass());

    }
}