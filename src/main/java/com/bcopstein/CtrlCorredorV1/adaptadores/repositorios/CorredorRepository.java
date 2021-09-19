package com.bcopstein.CtrlCorredorV1.adaptadores.repositorios;

import java.util.List;
import java.util.Optional;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.Corredor;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.ICorredorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CorredorRepository implements ICorredorRepository {
    private Corredor corredor;

    @Autowired
    public CorredorRepository(Corredor corredor) {
        this.corredor = corredor;
    }
    
    @Override
    public List<Corredor> todos() {
        return null;
    }

    // public void removeTodos(){
    //     // Limpa a base de dados
    //     this.jdbcTemplate.batchUpdate("DELETE from Corredores");
    // }

    // public boolean cadastra(Corredor corredor){
    //     // Então cadastra o novo "corredor único"
    //     this.jdbcTemplate.update("INSERT INTO corredores(cpf,nome,diaDn,mesDn,anoDn,genero) VALUES (?,?,?,?,?,?)",
    //     corredor.getCpf(), corredor.getNome(), corredor.getDiaDn(), corredor.getMesDn(), corredor.getAnoDn(),
    //     corredor.getGenero());
    //     return true;
    // }

    @Override
    public <S extends Corredor> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Corredor> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Corredor> findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<Corredor> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Corredor> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Corredor entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll(Iterable<? extends Corredor> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }
}
