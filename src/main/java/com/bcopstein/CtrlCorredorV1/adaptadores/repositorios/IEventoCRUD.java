package com.bcopstein.CtrlCorredorV1.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.Evento;

import org.springframework.data.repository.CrudRepository;

public interface IEventoCRUD extends CrudRepository<Evento, Long> {
    List<Evento> todos();
    boolean cadastra(Evento evento);
}
