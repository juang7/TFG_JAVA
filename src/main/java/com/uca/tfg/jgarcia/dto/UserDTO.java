package com.uca.tfg.jgarcia.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.uca.tfg.jgarcia.model.Alergia;

public class UserDTO implements Serializable {

private int id;
	
	private String nombre;
	private String email;
	private String apellido;
	private Date fecha_nacimiento;
	private List<AlergiaDTO> alergias;

	
	public UserDTO(int id, String nombre, String email, String apellido,
			Date fecha_nacimiento, List<AlergiaDTO> alergias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.alergias = alergias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public List<AlergiaDTO> getAlergias() {
		return alergias;
	}

	public void setAlergias(List<AlergiaDTO> alergias) {
		this.alergias = alergias;
	}

	public UserDTO() {
		super();
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", email=" + email + ", nombre=" + nombre + ", apellido="
				+ apellido + ", alergia=" + alergias + "]";
	}

}
