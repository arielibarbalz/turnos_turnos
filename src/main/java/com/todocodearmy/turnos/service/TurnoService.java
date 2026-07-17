package com.todocodearmy.turnos.service;

import com.todocodearmy.turnos.model.Paciente;
import com.todocodearmy.turnos.model.Turno;
import com.todocodearmy.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    private RestTemplate apiConsumir;

    @Override
    public List<Turno> getTurnos() {
        return turnoRepository.findAll();
    }

    @Override
    public void saveturno(LocalDate fecha, String tratamiento, String dniPaciente) {
        Paciente pac = apiConsumir.getForObject("http://localhost:9001/pacientes/traerdni/"+ dniPaciente, Paciente.class);
        String nombreCompletoPaciente = pac.getNombre() +" " + pac.getApellido();
        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombrCompletoPaciente(nombreCompletoPaciente);
        turnoRepository.save(turno);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Turno findTurno(long id) {
        return turnoRepository.findById(id).orElse(null);
    }

    @Override
    public void editTurno(Long id, Turno turno) {
            Turno turno1 = this.findTurno(id);
        turno1.setFecha(turno.getFecha());
        turno1.setTratamiento(turno.getTratamiento());
        turno1.setNombrCompletoPaciente(turno.getNombrCompletoPaciente());
        turnoRepository.save(turno1);
    }
}
