package com.autocinema.pe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Pelicula")
    private Long id;
	
	@Column(name = "titulo")
    private String titulo;

	@Column(name = "descripcion")
    private String descripcion;
	
	@Column(name = "duracion")
    private Integer duracion;
	
	@Column(name = "categoria")
    private Integer categoria_id;

	public Pelicula() {
		super();
	}

	public Pelicula(Long id, String titulo, String descripcion, Integer duracion, Integer categoria_id) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.categoria_id = categoria_id;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", duracion=" + duracion
				+ ", categoria_id=" + categoria_id + "]";
	}
	
	
}