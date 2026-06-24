package com.todocodearmy.turnos.controller;

import com.todocodearmy.turnos.model.Turno;
import com.todocodearmy.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnoService turnoServ;

    @PostMapping("/crear")
    public String crearTurno(@RequestBody LocalDate fecha, @RequestBody String tratamiento, @RequestBody String dniPaciente){
        turnoServ.saveturno(fecha, tratamiento, dniPaciente);
        return "Turno creado correctamente";
    }
    @GetMapping("/traer")
    public List<Turno> traerTurnos(){
        return turnoServ.getTurnos();
    }
    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id){
        turnoServ.deleteTurno(id);
        return "Turno eliminado correctamente";
    }
    @PutMapping("/editar/{id_original}")
    public Turno editTurno(@PathVariable Long id_original, @RequestBody Turno turnoEditar){
        turnoServ.editTurno(id_original, turnoEditar);
        Turno turnoEditado = turnoServ.findTurno(id_original);
        return turnoEditado;
    }
    @GetMapping("/traer/{id}")
    public Turno traerTurno(@PathVariable Long id){
        return turnoServ.findTurno(id);
    }


}
