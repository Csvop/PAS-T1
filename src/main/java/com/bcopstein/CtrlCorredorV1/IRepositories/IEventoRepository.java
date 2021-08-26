package com.bcopstein.CtrlCorredorV1.IRepositories;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.Models.Evento;

public interface IEventoRepository {
    public List<Evento> consultaEventos();
    public boolean informaEvento(Evento evento);
}