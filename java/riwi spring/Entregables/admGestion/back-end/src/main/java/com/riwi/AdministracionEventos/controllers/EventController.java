package com.riwi.AdministracionEventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.AdministracionEventos.entities.Events;
import com.riwi.AdministracionEventos.servivicies.EventService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
@RequestMapping("/api/v1/events")
@AllArgsConstructor

public class EventController {
    @Autowired
    private final EventService eventService;

    // Obtener todos los eventos
    @GetMapping
    public ResponseEntity<List<Events>> getAllEvents() {
        return ResponseEntity.ok(this.eventService.getAll());
    }

    // Obtener por id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Events> getEventById(@PathVariable("id") String id) {

        return ResponseEntity.ok(this.eventService.getById(id));
    }

    // Enviar eventos a la BD
    @PostMapping
    public ResponseEntity<Events> createEvent(@RequestBody Events event) {

        return ResponseEntity.ok(this.eventService.save(event));
    }

    // Eliminar eventos
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable String id) {
        this.eventService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Actualizar evento
    @PutMapping(path = "/{id}")
    public ResponseEntity<Events> updateEvent(@PathVariable String id, @RequestBody Events objEvent) {

        return ResponseEntity.ok(this.eventService.update(id, objEvent));
    }
    

}
