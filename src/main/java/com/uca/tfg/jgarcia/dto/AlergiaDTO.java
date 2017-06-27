package com.uca.tfg.jgarcia.dto;

public class AlergiaDTO {
	
	private int _id;
	private String descripcion;
	
	public AlergiaDTO() {}
	public AlergiaDTO(int _id, String descripcion) {
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


