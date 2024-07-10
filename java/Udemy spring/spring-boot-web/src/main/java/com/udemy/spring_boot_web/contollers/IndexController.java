package com.udemy.spring_boot_web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app") //Sirve para añadir todos los endpoint a un ruta o especie de carpeta donde estaran guardados
public class IndexController {

    @GetMapping("/index")

    //El model nos sirve para inyectar datos mendiante llave y valor al HTML
    //LE model tiene mpap
    public String index(Model model) {
        model.addAttribute("title", "Hello spring framework");
        return "index";
    }

}
