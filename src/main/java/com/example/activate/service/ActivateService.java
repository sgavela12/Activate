package com.example.activate.service;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class ActivateService {
    

    ArrayList<String> entrenadores = new ArrayList<String>() {
        {
            add("Juan González");
            add("María Rodríguez");
            add("Pedro Fernández");
            add("Ana López");
            add("Luis Martínez");
            add("Carmen Sánchez");
            add("Javier Pérez");
            add("Isabel Gómez");
            add("Miguel Martín");
            add("Laura Jiménez");
        }
    };

    public String mensajeFecha() {

        Calendar cal = Calendar.getInstance();

        return "Cambia tu " + cal.get(Calendar.YEAR) + "!";

    }

    public ArrayList<String> devuelveEntrenadores() {
        return entrenadores;
    }

       

   

}
