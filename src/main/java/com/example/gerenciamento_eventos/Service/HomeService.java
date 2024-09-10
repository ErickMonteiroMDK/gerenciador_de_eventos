package com.example.gerenciamento_eventos.Service;

import com.example.gerenciamento_eventos.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gerenciamento_eventos.Model.HomeModel;

@Service
public class HomeService {

    @Autowired
    private EventoRepository eventRepository;

    public HomeModel getHomeInfo() {
        HomeModel info = new HomeModel();
        info.setWelcomeMessage("Welcome to the Event Management System");
        info.setNumberOfEvents((int) eventRepository.count());
        return info;
    }
}
