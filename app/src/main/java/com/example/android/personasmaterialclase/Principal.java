package com.example.android.personasmaterialclase;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements AdaptadorPersona.OnPersonaClickListener{
    private RecyclerView listado;
    private ArrayList<Persona> personas;
    private Resources res;
    private AdaptadorPersona adapter;
    private LinearLayoutManager llm;
    private DatabaseReference databaseReference;
    private final String BD="Personas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listado = (RecyclerView)findViewById(R.id.lstPersona);
        res = this.getResources();
        personas = new ArrayList<>();
        //personas = Datos.obtenerPersona();
       /* personas.add(new Persona(R.drawable.images2,"1140877166","Andres","Cantillo",2));
        personas.add(new Persona(R.drawable.images3,"1234567890","Daniel","Cantillo",2));
        personas.add(new Persona(R.drawable.images,"09876543211","Natalia","Cantillo",2));
        personas.add(new Persona(R.drawable.images2,"1140877166","Andres","Cantillo",2));
        personas.add(new Persona(R.drawable.images3,"1234567890","Daniel","Cantillo",2));
        personas.add(new Persona(R.drawable.images,"09876543211","Natalia","Cantillo",2));
        personas.add(new Persona(R.drawable.images2,"1140877166","Andres","Cantillo",2));
        personas.add(new Persona(R.drawable.images3,"1234567890","Daniel","Cantillo",2));
        personas.add(new Persona(R.drawable.images,"09876543211","Natalia","Cantillo",2));
        personas.add(new Persona(R.drawable.images2,"1140877166","Andres","Cantillo",2));
        personas.add(new Persona(R.drawable.images3,"1234567890","Daniel","Cantillo",2));
        personas.add(new Persona(R.drawable.images,"09876543211","Natalia","Cantillo",2));
        personas.add(new Persona(R.drawable.images2,"1140877166","Andres","Cantillo",2));
        personas.add(new Persona(R.drawable.images3,"1234567890","Daniel","Cantillo",2));
        personas.add(new Persona(R.drawable.images,"09876543211","Natalia","Cantillo",2));*/

        adapter = new AdaptadorPersona(this.getApplicationContext(),personas,this);
        llm = new LinearLayoutManager(this);
        listado.setLayoutManager(llm);
        listado.setAdapter(adapter);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(BD).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                personas.clear();
                if (dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Persona p = snapshot.getValue(Persona.class);
                        personas.add(p);
                    }
                }
                adapter.notifyDataSetChanged();
                Datos.setPersonas(personas);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

      //  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    public void agregar(View v){
       /* Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();*/
        Intent i = new Intent(Principal.this,crearPersonas.class);
        startActivity(i);

    }

    @Override
    public void onPersonaClick(Persona p) {
        Intent i = new Intent(Principal.this,ModificarPersona.class);
        Bundle b = new Bundle();
        b.putString("id",p.getId());
        b.putString("cedula",p.getCedula());
        b.putString("nombre",p.getNombre());
        b.putString("apellido",p.getApellido());
        b.putString("foto",p.getFoto());

        i.putExtra("datos",b);
        startActivity(i);
    }
}
