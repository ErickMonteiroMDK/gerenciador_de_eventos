package com.example.gerenciamento_eventos.Service;

import com.example.gerenciamento_eventos.Model.EventoModel;
import com.example.gerenciamento_eventos.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<EventoModel> listarTodos() {
        return eventoRepository.findAll();
    }

    public EventoModel criarEvento(EventoModel evento) {
        return eventoRepository.save(evento);
    }

    public EventoModel atualizarEvento(Long id, EventoModel eventoAtualizado) {
        EventoModel evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        evento.setTitulo(eventoAtualizado.getTitulo());
        evento.setDescricao(eventoAtualizado.getDescricao());
        evento.setData(eventoAtualizado.getData());
        evento.setLocal(eventoAtualizado.getLocal());
        return eventoRepository.save(evento);
    }

    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    public List<EventoModel> buscarEventosPorNome(String nome) {
        return eventoRepository.findByTituloContainingIgnoreCase(nome);
    }

    public List<EventoModel> filtrarEventosPorData(LocalDate data) {
        return eventoRepository.findByData(data);
    }

    public List<EventoModel> filtrarEventosPorLocal(String local) {
        return eventoRepository.findByLocalContainingIgnoreCase(local);
    }

    public List<EventoModel> filtrarEventosPorCategoria(String categoria) {
        return eventoRepository.findByCategoriaContainingIgnoreCase(categoria);
    }
}
