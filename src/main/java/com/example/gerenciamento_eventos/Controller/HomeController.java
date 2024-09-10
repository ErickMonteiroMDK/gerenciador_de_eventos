package com.example.gerenciamento_eventos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.gerenciamento_eventos.Service.HomeService;

@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("homeInfo", homeService.getHomeInfo());
        return "home";
    }
}
