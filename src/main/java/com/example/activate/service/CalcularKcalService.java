package com.example.activate.service;

import com.example.activate.service.CalcularKcalServiceImpl.Sexo;
import com.example.activate.service.CalcularKcalServiceImpl.NivelActividad;

public interface CalcularKcalService {
    float calcularCalorias(Sexo sexo, int edad, double peso, double altura, NivelActividad nivelActividad);
}
