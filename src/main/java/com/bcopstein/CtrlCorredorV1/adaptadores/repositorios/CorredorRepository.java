package com.bcopstein.CtrlCorredorV1.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.Corredor;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.ICorredorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CorredorRepository implements ICorredorRepository {
    private ICorredorCRUD corredorCRUD;

    @Autowired
    public CorredorRepository(ICorredorCRUD corredorCRUD) {
        this.corredorCRUD = corredorCRUD;
    }
    
    @Override
    public List<Corredor> todos() {
        corredorCRUD.findAll();
        return null;
    }

    @Override
    public void removeTodos(){
        corredorCRUD.deleteAll();
    }

    @Override
    public boolean cadastra(Corredor corredor){
        corredorCRUD.save(corredor);
        return true;
    }
}