package com.riwi.AdministracionEventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.AdministracionEventos.entities.Events;

public interface EventsRepository extends JpaRepository <Events, String> {
    public Events findByName(String eventsName);
}
