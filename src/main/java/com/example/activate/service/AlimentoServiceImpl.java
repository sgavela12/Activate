package com.example.activate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.activate.models.Alimento;
import com.example.activate.repositories.AlimentoRepository;


@Service
public class AlimentoServiceImpl implements AlimentoService{
    @Autowired
    AlimentoRepository alimentoRepository;

    public Alimento añadir(Alimento alimento) {
        return alimentoRepository.save(alimento);
        
    }

    public List<Alimento> obtenerTodos() {
        return alimentoRepository.findAll();
    }

    public Alimento obtenerPorId(long id) {
        return alimentoRepository.findById(id).orElse(null);
    }

    public Alimento editar(Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    public void borrar(Long id) {
        alimentoRepository.deleteById(id);
    }
}
