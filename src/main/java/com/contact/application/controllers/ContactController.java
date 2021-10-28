package com.contact.application.controllers;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.application.entities.Contact;
import com.contact.application.repositories.ContactRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactController {
	@Autowired
	private ContactRepository cont_rep;
	
	@GetMapping("/contact")
	public ResponseEntity<?> getAllContact() {

		List<Contact> contact = cont_rep.findAll();
		if (contact.size() > 0) {
			return new ResponseEntity<List<Contact>>(contact, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Contact not available!", HttpStatus.NOT_FOUND);
		}

	}
	
	
	@PostMapping("/add_contact")
	public ResponseEntity<?> addContact(@RequestBody Contact contact) {
		try {
			cont_rep.save(contact);
			return new ResponseEntity<Contact>(contact, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/update_Contact/{id_con}")
	public ResponseEntity<?> updateContact(@RequestBody Contact contact, @PathVariable String id_con) {
		try {
			if (cont_rep.findById(id_con).isPresent()) {
				Contact existedcon = cont_rep.findById(id_con).get();
				if (contact.getNom().equals("")) {
					existedcon.setNom(existedcon.getNom());
				} else {
					existedcon.setNom(contact.getNom());
				}
				if (contact.getEmail().equals("")) {
					existedcon.setEmail(existedcon.getEmail());
				} else {
					existedcon.setEmail(contact.getEmail());
				}
				
				if (contact.getContenu().equals("")) {
					existedcon.setContenu(existedcon.getContenu());
				} else {
					existedcon.setContenu(contact.getContenu());
				}
				
				cont_rep.save(existedcon);
			} else {
				return new ResponseEntity<>("Contact not found!", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Contact>(contact, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
