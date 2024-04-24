package com.example.activate.service;

public class CalcularKcalServiceImpl {

    public enum Sexo {
        HOMBRE,
        MUJER
    }

    public enum NivelActividad {
        SEDENTARIO,
        LIGERO,
        MODERADO,
        ACTIVO,
        MUY_ACTIVO
    }

    public double calcularCalorias(Sexo sexo, int edad, double peso, double altura, NivelActividad nivelActividad) {
        double factorActividad = obtenerFactorActividad(nivelActividad);
        double metabolismoBasal = calcularMetabolismoBasal(sexo, edad, peso, altura);
        return metabolismoBasal * factorActividad;
    }

    private double calcularMetabolismoBasal(Sexo sexo, int edad, double peso, double altura) {
        if (sexo == Sexo.HOMBRE) {
            return 88.362 + (13.397 * peso) + (4.799 * altura) - (5.677 * edad);
        } else {
            return 447.593 + (9.247 * peso) + (3.098 * altura) - (4.330 * edad);
        }
    }

    private double obtenerFactorActividad(NivelActividad nivelActividad) {
        switch (nivelActividad) {
            case SEDENTARIO:
                return 1.2;
            case LIGERO:
                return 1.375;
            case MODERADO:
                return 1.55;
            case ACTIVO:
                return 1.725;
            case MUY_ACTIVO:
                return 1.9;
            default:
                throw new IllegalArgumentException("Nivel de actividad no válido");
        }
}
}