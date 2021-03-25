package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Прочий запросы к API.Обычные запросы не через API (главная страница - /, в частности)
 */
@Controller
public class DefaultController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
