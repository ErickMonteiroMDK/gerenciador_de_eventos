package com.example.gerenciamento_eventos.Scheduler;

import com.example.gerenciamento_eventos.Model.EventoModel;
import com.example.gerenciamento_eventos.Service.EventoService;
import com.example.gerenciamento_eventos.Service.NotifficationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class EventoReminderScheduler {

    @Autowired
    private EventoService eventService;

    @Autowired
    private NotifficationService notificationService;

    @Scheduled(cron = "0 0 8 * * *")
    public void sendDailyReminders() {
        List<EventoModel> events = eventService.listarTodos();
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);

        for (EventoModel event : events) {
            if (event.getData().equals(tomorrow)) {
                notificationService.sendEventReminder(
                        "user-email@example.com",  // Aqui você deve pegar o e-mail do usuário
                        "Lembrete de Evento: " + event.getTitulo(),
                        "O evento '" + event.getTitulo() + "' ocorrerá amanhã em " + event.getLocal() + "."
                );
            }
        }
    }
}
