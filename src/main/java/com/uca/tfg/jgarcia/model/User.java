package com.uca.tfg.jgarcia.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.uca.tfg.jgarcia.dto.AlergiaDTO;


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	//@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "user_alergia", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "alergia_id"))
	private List<Alergia> alergias;
	
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

	public List<Alergia> getAlergias() {
		return alergias;
	}

	public void setAlergias(List<Alergia> alergias) {
		this.alergias = alergias;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

