package com.example.lab02Rojas.Contacts.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lab02Rojas.Contacts.modelo.Contact;
import com.example.lab02Rojas.Contacts.repositorios.IContact;

@Service("contactq")
public class ContactService {
	
	@Autowired
	private IContact intercontact;
	public void savec(Contact contactq) {
		intercontact.save(contactq);
	}
	
	public List<Contact> listconjunt(){
		return intercontact.findAll();
	}
	
	public Contact searchbuscar(Long codigo) {
		return intercontact.findByCodigo(codigo);
	}
	
	public boolean eliminar(Long codigo) {
		try {
			intercontact.delete(intercontact.findByCodigo(codigo));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
