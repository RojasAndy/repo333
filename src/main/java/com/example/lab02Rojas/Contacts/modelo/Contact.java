package com.example.lab02Rojas.Contacts.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CONTACTS")
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	private String apellidos;
	
	@NotNull
	private String nombres;
	
	@NotNull
	private int phone;
	
	@NotNull
	private String correo;
	
	@NotNull
	private String direccion;
	
	@NotNull
	private String cumpleanos;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCumpleanos() {
		return cumpleanos;
	}

	public void setCumpleanos(String cumpleanos) {
		this.cumpleanos = cumpleanos;
	}

	@Override
	public String toString() {
		return "Contact [codigo=" + codigo + ", apellidos=" + apellidos + ", nombres=" + nombres + ", phone=" + phone
				+ ", correo=" + correo + ", direccion=" + direccion + ", cumpleanos=" + cumpleanos + "]";
	}
	
	
}
