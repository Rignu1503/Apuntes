package com.riwi.primeraweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.services.CoderService;

@Controller
@RequestMapping("/")
public class CoderCotroller {

    //Llamamos el servicio
    @Autowired
   private CoderService objCoderService;

   /*
    * Metodo para mostrar la listo y enviar la lista de coder
    */

    @GetMapping
    public String ShowViewGetAll(Model objModel){


        /* Llamo el servicio y guardo la lista de coder */
        List<Coder> list =  this.objCoderService.findAll();
        objModel.addAttribute("coderList", list); /* lavlle -valor */

        /* Se debe retornar el nombre exacto de la vista html */
        return "viewCoder";
    }
    

    @GetMapping("/insert")
    public String insert(Model objModel){

        List<Coder> list =  this.objCoderService.findAll();
        objModel.addAttribute("coderList", list); /* lavlle -valor */

        /* Se debe retornar el nombre exacto de la vista html */
        return "insert";

    }
}
