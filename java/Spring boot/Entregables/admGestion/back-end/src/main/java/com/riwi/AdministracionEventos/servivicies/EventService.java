package com.riwi.AdministracionEventos.servivicies;

import java.util.List;

import org.springframework.stereotype.Service;

import com.riwi.AdministracionEventos.entities.Events;
import com.riwi.AdministracionEventos.repositories.EventsRepository;
import com.riwi.AdministracionEventos.servivicies.Service_abstract.IEventsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventsService {

    private final EventsRepository EventRespository;

    @Override
    public Events save(Events events) {

        return this.EventRespository.save(events);
    }

    @Override
    public List<Events> getAll() {
        return this.EventRespository.findAll();
    }

    @Override
    public Events getById(String id) {
        return this.EventRespository.findById(id).orElse(null);
    }

    @Override
    public Events update(String id, Events objEvents) {
        this.EventRespository.findById(id).orElseThrow();
        objEvents.setId(id);

        return this.EventRespository.save(objEvents);

    }

    @Override
    public void delete(String id) {
        Events events = this.EventRespository.findById(id).orElse(null);
        if (events != null) {
            this.EventRespository.delete(events);
        }

    }
}
