package com.example.lab02Rojas.Security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name="users")
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int usu_codigo;
	
	@NotNull
	@Column(unique=true, length=50)
	private String usuario;
	
	@NotNull
	@Column(length=100)
	private String password;
	
	@NotNull
	private Byte activo;
	
	@NotNull
	private String role;

	public int getUsu_codigo() {
		return usu_codigo;
	}

	public void setUsu_codigo(int usu_codigo) {
		this.usu_codigo = usu_codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getActivo() {
		return activo;
	}

	public void setActivo(Byte activo) {
		this.activo = activo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [usu_codigo=" + usu_codigo + ", usuario=" + usuario + ", password=" + password + ", activo="
				+ activo + ", role=" + role + "]";
	}
	
	
	
	
	

}
