package main.java.com.daw.springboot.Controller;

import com.ejemplo.proyecto.model.Videojuego;
import com.ejemplo.proyecto.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    //  LISTAR + FILTRADO Y ORDENACIÓN
    @GetMapping
    public String listarVideojuegos(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Videojuego> lista;
        if (keyword != null && !keyword.isEmpty()) {
            lista = videojuegoRepository.findByTituloContainingIgnoreCaseOrderByTituloAsc(keyword);
        } else {
            lista = videojuegoRepository.findAllByOrderByTituloAsc();
        }
        model.addAttribute("videojuegos", lista);
        model.addAttribute("keyword", keyword); // Para mantener el texto en la barra de búsqueda
        return "listado"; 
    }

    // VISTA DETALLADA
    @GetMapping("/{id}")
    public String mostrarDetalles(@PathVariable Long id, Model model) {
        Optional<Videojuego> juego = videojuegoRepository.findById(id);
        if (juego.isPresent()) {
            model.addAttribute("videojuego", juego.get());
            return "detalles";
        }
        return "redirect:/videojuegos";
    }

    //  FORMULARIO DE CREACIÓN (Muestra vista)
    @GetMapping("/add")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("videojuego", new Videojuego());
        return "registro";
    }

    //  PROCESAR CREACIÓN (POST)
    @PostMapping
    public String guardarVideojuego(@ModelAttribute Videojuego nuevoJuego) {
        videojuegoRepository.save(nuevoJuego);
        return "redirect:/videojuegos";
    }

    // FORMULARIO DE EDICIÓN (Muestra vista con datos precargados)
    @GetMapping("/edit/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<Videojuego> juego = videojuegoRepository.findById(id);
        if (juego.isPresent()) {
            model.addAttribute("videojuego", juego.get());
            return "editar";
        }
        return "redirect:/videojuegos";
    }

    //  PROCESAR EDICIÓN (POST)
    @PostMapping("/edit/{id}")
    public String editarVideojuego(@PathVariable Long id, @ModelAttribute Videojuego juegoEditado) {
        juegoEditado.setId(id); // Asegura que se actualiza el id correspondiente
        videojuegoRepository.save(juegoEditado);
        return "redirect:/videojuegos";
    }

    //  ELIMINAR ELEMENTO
    @GetMapping("/eliminar/{id}")
    public String eliminarVideojuego(@PathVariable Long id) {
        videojuegoRepository.deleteById(id);
        return "redirect:/videojuegos";
    }
}