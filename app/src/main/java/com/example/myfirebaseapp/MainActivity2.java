package com.example.myfirebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myfirebaseapp.model.Rutina;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class MainActivity2 extends AppCompatActivity {

    private List<Rutina> listRutina = new ArrayList<Rutina>();
    ArrayAdapter<Rutina> arrayAdapterRutina;
    EditText nuevaR;
    ListView listaR;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Rutina rutinaSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Agregar rutina");

        nuevaR = findViewById(R.id.txt_nombreRutina);
        listaR = findViewById(R.id.datosRutinas);

        inicializarFirebase();
        listarDatos();

        listaR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                rutinaSelected = (Rutina) parent.getItemAtPosition(position);
                nuevaR.setText(rutinaSelected.getTexto());
            }
        });
    }

    private void listarDatos() {
        databaseReference.child("rutinas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listRutina.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                    Rutina r = objSnaptshot.getValue(Rutina.class);
                    listRutina.add(r);
                    arrayAdapterRutina = new ArrayAdapter<Rutina>(MainActivity2.this, android.R.layout.simple_list_item_1, listRutina);
                    listaR.setAdapter(arrayAdapterRutina);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String nombre = nuevaR.getText().toString();

        switch (item.getItemId()){
            case R.id.icon_add:{
                if(nombre.equals("")){
                    validacion();
                }else{
                    Rutina r = new Rutina();
                    r.setRid(UUID.randomUUID().toString());
                    r.setTexto(nombre);
                    databaseReference.child("rutinas").child(r.getRid()).setValue(r);
                    Toast.makeText(this, "Rutina agregada", Toast.LENGTH_SHORT).show();
                    limpiarCaja();
                }
                break;
            }
            case R.id.icon_save:{
                Rutina r = new Rutina();
                r.setRid(rutinaSelected.getRid());
                r.setTexto(nuevaR.getText().toString().trim());
                databaseReference.child("rutinas").child(r.getRid()).setValue(r);
                Toast.makeText(this, "Rutina actualizada", Toast.LENGTH_SHORT).show();
                limpiarCaja();
                break;
            }
            case R.id.icon_delete:{
                Rutina r = new Rutina();
                r.setRid(rutinaSelected.getRid());
                databaseReference.child("rutinas").child(r.getRid()).removeValue();
                Toast.makeText(this, "Rutina borrada", Toast.LENGTH_SHORT).show();
                limpiarCaja();
                break;
            }
            default:break;
        }
        return true;
    }

    private void limpiarCaja() {
        nuevaR.setText("");
    }

    private void validacion() {
        String nombre = nuevaR.getText().toString();
        if(nombre.equals("")){
            nuevaR.setError("Required");
        }
    }
}