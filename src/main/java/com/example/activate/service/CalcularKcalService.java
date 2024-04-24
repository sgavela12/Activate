package com.example.activate.service;

import com.example.activate.service.CalcularKcalServiceImpl.NivelActividad;
import com.example.activate.service.CalcularKcalServiceImpl.Sexo;

public interface CalcularKcalService {
    public float calcularKcal(Sexo sexo, int edad, double peso, double altura, NivelActividad nivelActividad );
}
