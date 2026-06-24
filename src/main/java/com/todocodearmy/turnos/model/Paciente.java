package com.todocodearmy.turnos.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paciente {
    private Long idPaciente;
    private String dni;
    private String nombre;
    private String apellido;
    private Date fechaNac;
    private String telefono;
}
