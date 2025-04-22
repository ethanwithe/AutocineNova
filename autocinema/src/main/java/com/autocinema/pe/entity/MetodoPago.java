package com.autocinema.pe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_metodos_pago")
    private Long id;

    @Column(name = "metodo")
    private String metodo;


	public MetodoPago() {
		super();
	}


	public MetodoPago(Long id, String metodo) {
		super();
		this.id = id;
		this.metodo = metodo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMetodo() {
		return metodo;
	}


	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}


	@Override
	public String toString() {
		return "MetodoPago [id=" + id + ", metodo=" + metodo + "]";
	}


}