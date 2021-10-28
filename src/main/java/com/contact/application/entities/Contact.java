package com.contact.application.entities;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Document(collection="contact")
public class Contact {
	@Id
	private String id;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getContenu() {
		return Contenu;
	}

	public void setContenu(String contenu) {
		Contenu = contenu;
	}

	private String Nom;
	
	private String Email;

	private String Contenu;

}
