package com.example.gerenciamento_eventos.Repository;

import com.example.gerenciamento_eventos.Model.HomeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeReposiroty extends JpaRepository<HomeModel, Long> {
}
