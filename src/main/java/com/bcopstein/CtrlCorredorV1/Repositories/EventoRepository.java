package com.bcopstein.CtrlCorredorV1.Repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.bcopstein.CtrlCorredorV1.IRepositories.IEventoRepository;
import com.bcopstein.CtrlCorredorV1.Models.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.Models.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventoRepository implements IEventoRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    EventoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        
        this.jdbcTemplate.execute("DROP TABLE eventos IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE eventos("
                + "id int, nome VARCHAR(255), dia int, mes int, ano int, distancia int, horas int, minutos int, segundos int,PRIMARY KEY(id))");
        
        this.jdbcTemplate.batchUpdate(
            "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
            " ('1','Poa Day Run',22,5,2019,5,0,35,32)");
        this.jdbcTemplate.batchUpdate(
            "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
            " ('2','Corrida Regional do Bruno',22,5,2019,5,2,50,122)");
        this.jdbcTemplate.batchUpdate(
            "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
            " ('3','Corrida Internacional do Leozada',22,5,2019,5,1,3,200)");
        this.jdbcTemplate.batchUpdate(
            "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
            " ('4','Corrida Mamaleona',22,5,2019,5,5,7,20)");
        //{35, 172, 66, 307}
    }

    @Override
    public List<Evento> consultaEventos() {
        List<Evento> resp = this.jdbcTemplate.query("SELECT * from eventos",
                (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
                        rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
                        rs.getInt("segundos")));
        return resp;
    }

    @Override
    public boolean informaEvento(Evento evento) {
        this.jdbcTemplate.update(
                "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (?,?,?,?,?,?,?,?,?)",
                evento.getId(), evento.getNome(), evento.getDia(), evento.getMes(), evento.getAno(),
                evento.getDistancia(), evento.getHoras(), evento.getMinutos(), evento.getSegundos());
        return true;
    }

    private int tempoMinutos(int hora, int minuto, int segundo) {
        int minutos = (hora*60) + (minuto) + (segundo/60);
        return minutos;
    }

    private double getMedia(List<Evento> eventos, double tam) {
        double media = 0;
        
        for(Evento evento : eventos) {
            media = media + tempoMinutos(evento.getHoras(), evento.getMinutos(), evento.getSegundos());
        }

        return media/tam;
    }

    private double getMediana(List<Evento> eventos) {
        double mediana = 0;

        List<Integer> listaDeMinutos = new ArrayList<>();
        for(Evento evento : eventos) {
           listaDeMinutos.add(tempoMinutos(evento.getHoras(), evento.getMinutos(), evento.getSegundos()));
        }

        Collections.sort(listaDeMinutos);
        
        int tam = listaDeMinutos.size();

        if(tam%2==0) {
            mediana = (listaDeMinutos.get((tam/2)-1) + listaDeMinutos.get(tam/2))/2;
        } else {
            mediana = listaDeMinutos.get(tam/2);
        }

        return mediana;
    }

    private double getDesvioPadrao(List<Evento> eventos, int distancia, int tam) {
        double media = getMedia(eventos, tam);
        double desvioPadrao = 0;

        for(Evento evento : eventos) {
            double aux = tempoMinutos(evento.getHoras(), evento.getMinutos(), evento.getSegundos()) - media;
            desvioPadrao += aux * aux;
        }
        return Math.sqrt(desvioPadrao / (tam-1));
    }

    @Override
    public EstatisticasDTO consultaEstatisticas(int distancia) {
        List<Evento> resp = this.jdbcTemplate.query("SELECT * FROM eventos WHERE distancia = "+distancia, 
        (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
            rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
            rs.getInt("segundos")));
        
        int quantidadeDeProvas = resp.size();
        double media = getMedia(resp, quantidadeDeProvas);
        double mediana = getMediana(resp);
        double desvioPadrao = getDesvioPadrao(resp, distancia, quantidadeDeProvas);

        return new EstatisticasDTO(quantidadeDeProvas, media, mediana, desvioPadrao);
    }

}
