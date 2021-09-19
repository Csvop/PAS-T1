package com.bcopstein.CtrlCorredorV1.negocio.repositorios;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.Corredor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ICorredorRepository extends CrudRepository<Corredor, Long>{
    @Query("SELECT * from corredores")
    List<Corredor> todos();
    // void removeTodos();
    // boolean cadastra(Corredor corredor);
}
