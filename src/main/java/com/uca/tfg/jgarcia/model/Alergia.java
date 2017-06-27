package com.uca.tfg.jgarcia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alergia")
public class Alergia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "alergia_id")
	private int _id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public Alergia() {}
	public Alergia(int _id, String descripcion) {
		super();
		this._id = _id;
		this.descripcion = descripcion;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int i) {
		this._id = i;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
