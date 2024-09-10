package com.example.gerenciamento_eventos.Repository; // Confirme se o pacote está correto

import com.example.gerenciamento_eventos.Model.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<EventoModel, Long> {
    List<EventoModel> findByTituloContainingIgnoreCase(String titulo);
    List<EventoModel> findByData(LocalDate data);
    List<EventoModel> findByLocalContainingIgnoreCase(String local);
    List<EventoModel> findByCategoriaContainingIgnoreCase(String categoria); // Adicione este método
}
