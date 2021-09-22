package com.bcopstein.CtrlCorredorV1.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.Corredor;

import org.springframework.data.repository.CrudRepository;

public interface ICorredorCRUD extends CrudRepository<Corredor, Long> {
    List<Corredor> todos();
    void removeTodos();
    boolean cadastra(Corredor corredor);
}