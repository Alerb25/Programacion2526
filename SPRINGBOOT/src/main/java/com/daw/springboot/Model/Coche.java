package com.daw.springboot.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coche {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //para que sea autoincremental
	private Long idCoche;
    @Nullable    
	private String marca;
	private int anno;
	private int potencia;
    private String modelo;
    // Constructor, getters y setters

}
