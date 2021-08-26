package com.bcopstein.CtrlCorredorV1.Repositories;

import java.util.*;

import com.bcopstein.CtrlCorredorV1.IRepositories.ICorredorRepository;
import com.bcopstein.CtrlCorredorV1.Models.Corredor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CorredorRepository implements ICorredorRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    CorredorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        this.jdbcTemplate.execute("DROP TABLE corredores IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE corredores("
                + "cpf VARCHAR(255), nome VARCHAR(255), genero VARCHAR(255), diaDn int, mesDn int, anoDn int, PRIMARY KEY(cpf))");

        this.jdbcTemplate.batchUpdate(
                "INSERT INTO corredores(cpf,nome,genero,diaDn,mesDn,anoDn) VALUES ('10001287','Luiz','masculino',22,5,1987)");
        this.jdbcTemplate.batchUpdate(
                "INSERT INTO corredores(cpf,nome,genero,diaDn,mesDn,anoDn) VALUES ('10001288','Rakan','masculino',2,2,2002)");
        this.jdbcTemplate.batchUpdate(
                "INSERT INTO corredores(cpf,nome,genero,diaDn,mesDn,anoDn) VALUES ('10001289','Darius','masculino',31,3,1999)");
        this.jdbcTemplate.batchUpdate(
                "INSERT INTO corredores(cpf,nome,genero,diaDn,mesDn,anoDn) VALUES ('10001290','Katarina','feminino',17,11,1997)");
        this.jdbcTemplate.batchUpdate(
                "INSERT INTO corredores(cpf,nome,genero,diaDn,mesDn,anoDn) VALUES ('10001291','Diana','feminino',20,10,2000)");
    }

    @Override
    public List<Corredor> consultaCorredores() {
        List<Corredor> resp = this.jdbcTemplate.query("SELECT * from corredores",
                (rs, rowNum) -> new Corredor(rs.getString("cpf"), rs.getString("nome"), rs.getInt("diaDn"),
                        rs.getInt("mesDn"), rs.getInt("anoDn"), rs.getString("genero")));
        return resp;
    }

    @Override
    public boolean cadastraCorredor(Corredor corredor) {
        this.jdbcTemplate.batchUpdate("DELETE from Corredores");
        this.jdbcTemplate.update("INSERT INTO corredores(cpf,nome,diaDn,mesDn,anoDn,genero) VALUES (?,?,?,?,?,?)",
                corredor.getCpf(), corredor.getNome(), corredor.getDiaDn(), corredor.getMesDn(), corredor.getAnoDn(),
                corredor.getGenero());
        return true;
    }
  
}
