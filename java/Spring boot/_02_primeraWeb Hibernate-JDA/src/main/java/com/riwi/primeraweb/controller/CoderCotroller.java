package com.riwi.primeraweb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String ShowViewGetAll(Model objModel, @RequestParam (defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size){

        /* Llamo el servicio y guardo la lista de coder */
        Page<Coder> list =  this.objCoderService.fingPaginated(page-1, size);
        objModel.addAttribute("coderList", list); /* llave -valor */
        objModel.addAttribute("currentPage", page);
        objModel.addAttribute("totalPages", list.getTotalPages()); 

        /* Se debe retornar el nombre exacto de la vista html */
        return "viewCoder";
    }


    @GetMapping("/form")
    /*
     * Metodo para mostrar la lista y enviar la lista de coder
     */
    public String insert(Model objModel){
        /* Llamo el servicio y guardo la lista de coder */
        objModel.addAttribute("coder", new Coder()); //La vista va a reconocer lo que se envie con el nombre de coder
        objModel.addAttribute("action", "/coder/create"); 

        /* Se debe retornar el nombre exacto de la vista html */
        return "insertCoder";
    }

    /* MEtodo para mostrar el formulario de actualizar coder */
    @GetMapping("/update/{id}")
    public String showFromUpdate(@PathVariable Long id, Model objModel){

        Coder objCoderFind = this.objCoderService.findById(id);
        objModel.addAttribute("coder",objCoderFind); //La vista va a reconocer lo que se envie con el nombre de coder
        objModel.addAttribute("action", "/edit/" + id); 

        return "insertCoder";
    }

    /* Metodo para actualizar */
    @PostMapping("edit/{id}")
    public String updateCoder(@PathVariable Long id, @ModelAttribute Coder objCoder){
        this.objCoderService.update(id, objCoder);

        return "redirect:/";

      
    }

    
    /****
     * Metodo para insertar un coder mediante eel verbo POST
     * @ModelAttribute se encarga de recibir los datos del formulario
     * 
     */

    @PostMapping("coder/create")
    //El objCoder es lo que nos envia la vista
    public String createCoder(@ModelAttribute Coder objCoder){

        //Llamamos al servicio enviandole el coder a insertar 
        this.objCoderService.insert(objCoder);
        return "redirect:/";
    }

    /*Eliminar */

    @GetMapping("/delete/{id}")
    public String deleteCoder(@PathVariable Long id){

        this.objCoderService.delete(id);
        return "redirect:/";
    }
}
