package com.riwi.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;


//Se agrega esta anotacion para agregar el frijol a la lata
/*Indica que esta clase será un controlador */
@Controller
/*RequestMapping: Crea una ruta base al controlador */
@RequestMapping("/controller")

public class HolaMundo {

    /*Getmapping: crea una ruta especifica para el método */
    @GetMapping("/holamundo")

    /*ResponseBody: Nos permite respoder en el navegador */
    @ResponseBody
    
    public String mostrarMensaje(){
        return "Hola mundo";
    }


        /*Getmapping: crea una ruta especifica para el nuevo método */
        @GetMapping("/suma")

        /*ResponseBody: Nos permite respoder en el navegador de la nueva ruta */
        @ResponseBody
    public String suma() {
        int a, b;
        a = 2;
        b = 3;

        return String.valueOf(a + b);
    }

    
}
