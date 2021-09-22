package com.bcopstein.CtrlCorredorV1.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.Evento;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.IEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoRepository implements IEventoRepository{
    private IEventoCRUD eventoCRUD;
    
    @Autowired
    public EventoRepository(IEventoCRUD eventoCRUD) {
        this.eventoCRUD = eventoCRUD;
    }

    @Override
    public List<Evento> todos() {
        eventoCRUD.findAll();
        return null;
    }

    @Override
    public boolean cadastra(Evento evento){
        eventoCRUD.save(evento);
        return true;
    }
}