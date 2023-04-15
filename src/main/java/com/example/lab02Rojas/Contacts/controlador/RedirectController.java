package com.example.lab02Rojas.Contacts.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.lab02Rojas.Contacts.modelo.Contact;
import com.example.lab02Rojas.Contacts.servicios.ContactService;

@Controller
@RequestMapping("/")
@SessionAttributes("contact")
public class RedirectController {
	@Autowired
	ContactService contserv;
	
	@RequestMapping("/")
	public String listarcontacts (Model mod) {
		List<Contact> contactolista = contserv.listconjunt();
		mod.addAttribute("contactsalltag",contactolista);
		return "redirect:/contactspage/lista";
	}
}
