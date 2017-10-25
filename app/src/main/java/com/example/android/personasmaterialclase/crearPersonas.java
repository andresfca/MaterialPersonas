package com.example.android.personasmaterialclase;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    public void agregar(View v){
        if(validar()){
            Persona p = new Persona(Metodos.fotoAleatoria(fotos),txtCedula.getText().toString(),txtNombre.getText().toString(),txtApellido.getText().toString());
            p.guardar();
            Snackbar.make(v,res.getString(R.string.mensaje_persona_guardada_exitosamente),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            limpiar();
        }
    }
    public void limpiar(View v){
        limpiar();
    }
    public void limpiar(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.requestFocus();
        InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }
    public void onBackPressed(){
        finish();
        Intent i = new Intent(crearPersonas.this,Principal.class);
        startActivity(i);
    }
}
