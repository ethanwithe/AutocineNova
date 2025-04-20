package com.autocinema.pe.entity;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="funciones")
public class Funciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "hora")
	private Time hora;

	@Column(name = "pelicula_id")
	private Integer pelicula;
	
	@Column(name = "sala_id")
	private Integer sala;

	public Funciones() {
		super();
	}

	public Funciones(Long id, Date fecha, Time hora, Integer pelicula, Integer sala) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.pelicula = pelicula;
		this.sala = sala;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Integer getPelicula() {
		return pelicula;
	}

	public void setPelicula(Integer pelicula) {
		this.pelicula = pelicula;
	}

	public Integer getSala() {
		return sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "Funciones [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", pelicula=" + pelicula + ", sala="
				+ sala + "]";
	}
	
	
	

}
