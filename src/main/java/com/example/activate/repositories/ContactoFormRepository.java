package com.example.activate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.activate.models.ContactoForm;

public interface ContactoFormRepository extends JpaRepository<ContactoForm, Long> {
}
