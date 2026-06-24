package com.todocodearmy.turnos.service;

import com.todocodearmy.turnos.model.Turno;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {
    public List<Turno> getTurnos();
    public void saveturno(LocalDate fecha, String tratamiento, String dniPaciente);
    public void deleteTurno(Long id);
    public Turno findTurno(long id);
    public void editTurno(Long id, Turno turno);
}