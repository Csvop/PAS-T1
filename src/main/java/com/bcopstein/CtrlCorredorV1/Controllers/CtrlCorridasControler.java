package com.bcopstein.CtrlCorredorV1.Controllers;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.Models.Corredor;
import com.bcopstein.CtrlCorredorV1.Models.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.Models.Evento;
import com.bcopstein.CtrlCorredorV1.Repositories.CorredorRepository;
import com.bcopstein.CtrlCorredorV1.Repositories.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctrlCorridas")
public class CtrlCorridasControler {
    private CorredorRepository corredorRepository;
    private EventoRepository eventoRepository;

    @Autowired
    public CtrlCorridasControler(CorredorRepository corredorRepository, EventoRepository eventoRepository) { // Injecao de Dependencia
        this.corredorRepository = corredorRepository;
        this.eventoRepository = eventoRepository;
    }

    @GetMapping("/corredor")
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredores() {
            return corredorRepository.consultaCorredores();
    }

    @PostMapping("/corredor")
    @CrossOrigin(origins = "*")
    public boolean cadastraCorredor(@RequestBody final Corredor corredor) {
        return corredorRepository.cadastraCorredor(corredor);
    }

    @GetMapping("/eventos")
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        return eventoRepository.consultaEventos();
    }

    @PostMapping("/eventos") // adiciona evento no único corredor
    @CrossOrigin(origins = "*")
    public boolean informaEvento(@RequestBody final Evento evento) {
        return eventoRepository.informaEvento(evento);
    }

    @GetMapping("/estatisticas")
    @CrossOrigin(origins = "*")
    public EstatisticasDTO estatisticas(@RequestParam int d) {
        return eventoRepository.consultaEstatisticas(d);
    }
}