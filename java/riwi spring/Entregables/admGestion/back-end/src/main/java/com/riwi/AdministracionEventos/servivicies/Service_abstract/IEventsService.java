package com.riwi.AdministracionEventos.servivicies.Service_abstract;

import java.util.List;

import com.riwi.AdministracionEventos.entities.Events;

public interface IEventsService {
    
    public Events save(Events events);

    public List<Events> getAll();

    public Events getById(String id);

    public Events update(String id, Events events);

    public void delete(String id);


}
