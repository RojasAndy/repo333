package com.example.lab02Rojas.Contacts.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lab02Rojas.Contacts.modelo.Contact;

@Repository
public interface IContact extends JpaRepository<Contact, Serializable>{
	public abstract Contact findByCodigo(Long codigo);
}
