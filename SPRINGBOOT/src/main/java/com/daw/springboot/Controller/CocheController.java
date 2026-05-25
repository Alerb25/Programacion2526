package com.daw.springboot.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daw.springboot.Model.Coche;
import com.daw.springboot.Model.CocheRepository;


@Controller
public class CocheController {
    
    @Autowired
    public CocheRepository cocheRepository;

    @GetMapping("/coches")
    public String getCoches(Model model){
        List<Coche> listaCoches = cocheRepository.findAll();
        model.addAttribute("listacoches", listaCoches);
        return "listado";
    }
}
