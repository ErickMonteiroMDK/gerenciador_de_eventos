package com.example.gerenciamento_eventos.Controller;

import com.example.gerenciamento_eventos.Model.EventoModel;
import com.example.gerenciamento_eventos.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<EventoModel> listarTodos() {
        return eventoService.listarTodos();
    }

    @PostMapping
    public EventoModel criarEvento(@RequestBody EventoModel evento) {
        return eventoService.criarEvento(evento);
    }

    @PutMapping("/{id}")
    public EventoModel atualizarEvento(@PathVariable Long id, @RequestBody EventoModel eventoAtualizado) {
        return eventoService.atualizarEvento(id, eventoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarEvento(@PathVariable Long id) {
        eventoService.deletarEvento(id);
    }

    @GetMapping("/buscar")
    public List<EventoModel> buscarEventosPorNome(@RequestParam String nome) {
        return eventoService.buscarEventosPorNome(nome);
    }

    @GetMapping("/filtrar")
    public List<EventoModel> filtrarEventos(
            @RequestParam(required = false) LocalDate data,
            @RequestParam(required = false) String local,
            @RequestParam(required = false) String categoria) {
        if (data != null) {
            return eventoService.filtrarEventosPorData(data);
        } else if (local != null) {
            return eventoService.filtrarEventosPorLocal(local);
        } else if (categoria != null) {
            return eventoService.filtrarEventosPorCategoria(categoria);
        } else {
            return eventoService.listarTodos(); 
        }
    }
}
