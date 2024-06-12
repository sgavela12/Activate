package com.example.activate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.activate.models.ContactoForm;
import com.example.activate.repositories.ContactoFormRepository;

@Service
public class ContactoFormServiceImpl {

    @Autowired
    private final ContactoFormRepository contactoFormRepository;

    
    public ContactoFormServiceImpl(ContactoFormRepository contactoFormRepository) {
        this.contactoFormRepository = contactoFormRepository;
    }

    public List<ContactoForm> obtenerTodos() {
        return contactoFormRepository.findAll();
    }

    public ContactoForm guardar(ContactoForm contactoForm) {
        return contactoFormRepository.save(contactoForm);
    }
}
