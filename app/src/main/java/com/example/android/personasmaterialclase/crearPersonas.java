package com.example.android.personasmaterialclase;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class crearPersonas extends AppCompatActivity {
    private EditText txtCedula;
    private EditText txtNombre;
    private EditText txtApellido;
    private ArrayList<Integer>fotos;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_personas);

        txtCedula=(EditText)findViewById(R.id.txtCedula);
        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtApellido=(EditText)findViewById(R.id.txtApellido);

        res = this.getResources();
        inicializar_fotos();

    }
    public void inicializar_fotos(){
        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
    }

    public boolean validar() {
        String aux = res.getString(R.string.Campos_vacios);
        if (Metodos.validar_aux(txtCedula, aux)) return false;
            else if(Metodos.validar_aux(txtNombre,aux))return false;
            else if(Metodos.validar_aux(txtApellido,aux))return false;
        return true;

    }
    public void limpiar(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");

    }

}
