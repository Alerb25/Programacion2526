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
    public Coche() {
    }  

    public Coche(String marca, int anno, int potencia, String modelo) {
        this.marca = marca;
        this.anno = anno;
        this.potencia = potencia;
        this.modelo = modelo;
    }

    public Long getIdCoche() {
        return idCoche;
    }
    public void setIdCoche(Long idCoche) {
        this.idCoche = idCoche;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getAnno() {
        return anno;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
