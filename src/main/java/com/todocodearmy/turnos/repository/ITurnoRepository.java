package com.todocodearmy.turnos.repository;

import com.todocodearmy.turnos.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
