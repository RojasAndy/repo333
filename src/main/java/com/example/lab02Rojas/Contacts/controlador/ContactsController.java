package com.example.lab02Rojas.Contacts.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.lab02Rojas.Contacts.modelo.Contact;
import com.example.lab02Rojas.Contacts.servicios.ContactService;

@Controller
@RequestMapping("/contactspage")
@SessionAttributes("contact")
public class ContactsController {
	
	@Autowired
	ContactService contserv;
	
	@RequestMapping("/lista")
	public String listarcontacts (Model mod) {
		List<Contact> contactolista = contserv.listconjunt();
		mod.addAttribute("contactsalltag",contactolista);
		return "contactolista";
	}
	
	@RequestMapping("/registrocont")
	public String formulario (Map<String, Object> mod) {
		Contact contactmodel = new Contact();
		mod.put("contact", contactmodel);
		mod.put("Regitexthtml", "Registrar Contacto");
		return "contactoformulario";
	}
	
	@RequestMapping("/registrocont/{codigo}")
	public String actualizar (@PathVariable("codigo")  Long codigo,  Model mdc) {
		mdc.addAttribute("contact", contserv.searchbuscar(codigo));
		mdc.addAttribute("Regitexthtml", "Editar Contacto");
		return "contactoformulario";
	}
	
	@RequestMapping(value="/insertando", method=RequestMethod.POST)
	public String insertar(@Validated Contact contact, BindingResult resultbn, Model modi) {
		if(resultbn.hasErrors()) {
			modi.addAttribute("ERROR", "Error al registrar");
			contact = new Contact();
			modi.addAttribute("contact",contact);
			modi.addAttribute("Regitexthtml", "Registrar Contacto");
			return "contactoformulario";
		}else {
			contserv.savec(contact);
			return "redirect:/contactspage/lista";
		}
	}
	
	@RequestMapping("/eliminar/{codigo}")
	public String elimnarcont(@PathVariable("codigo") Long codigo) {
		contserv.eliminar(codigo);
		return "redirect:/contactspage/lista";
	}
	

	
	
	
}
