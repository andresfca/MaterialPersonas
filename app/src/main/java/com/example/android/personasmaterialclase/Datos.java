package com.example.android.personasmaterialclase;

import java.util.ArrayList;

/**
 * Created by android on 17/10/2017.
 */

public class Datos {
    private static ArrayList<Persona> personas = new ArrayList<>();
    public static void guardarPersona(Persona p){
        personas.add(p);
    }
    public static ArrayList<Persona> obtenerPersona(){
        return personas;
    }
}
