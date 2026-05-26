package com.daw.springboot.Model;

import com.daw.springboot.Model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    
    // Método personalizado derivado para filtrar por título ignorando mayúsculas y ordenando alfabéticamente
    List<Videojuego> findByTituloContainingIgnoreCaseOrderByTituloAsc(String titulo);
    
    // Método para listar todo ordenado por título por defecto
    List<Videojuego> findAllByOrderByTituloAsc();
}