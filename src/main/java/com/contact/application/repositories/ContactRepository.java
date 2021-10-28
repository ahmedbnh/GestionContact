package com.contact.application.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.contact.application.entities.Contact;

public interface ContactRepository extends MongoRepository<Contact, String>{

}
