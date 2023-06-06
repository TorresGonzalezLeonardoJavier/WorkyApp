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

import com.example.myfirebaseapp.model.persona;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private List<persona> listPerson = new ArrayList<persona>();
    ArrayAdapter<persona> arrayAdapterPersona;
    EditText nomP, appP, correoP, contraP;
    ListView listV_Personas;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    persona personSelectred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomP = findViewById(R.id.txt_nombrePersona);
        appP = findViewById(R.id.txt_appPersona);
        correoP = findViewById(R.id.txt_correoPersona);
        contraP = findViewById(R.id.txt_passwordPersona);

        listV_Personas= findViewById(R.id.datosPersonas);
        inicializarFirebase();
        listarDatos();

        listV_Personas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                personSelectred = (persona) parent.getItemAtPosition(position);
                nomP.setText(personSelectred.getNombre());
                appP.setText(personSelectred.getApellidos());
                correoP.setText(personSelectred.getCorreo());
                contraP.setText(personSelectred.getPassword());
            }
        });
    }

    private void listarDatos() {
        databaseReference.child("persona").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                listPerson.clear();
                for(DataSnapshot objSnapshot : datasnapshot.getChildren()){
                    persona p = objSnapshot.getValue(persona.class);
                    listPerson.add(p);
                    arrayAdapterPersona = new ArrayAdapter<persona>(MainActivity.this, android.R.layout.simple_list_item_1, listPerson);
                    listV_Personas.setAdapter(arrayAdapterPersona);
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
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String nombre = nomP.getText().toString();
        String apellidos = appP.getText().toString();
        String contraseña = contraP.getText().toString();
        String correo = correoP.getText().toString();

        switch (item.getItemId()){
            case R.id.icon_add:{
                if(nombre.equals("") || apellidos.equals("") || contraseña.equals("") || correo.equals("")){
                    validacion();
                }else{
                    persona p = new persona();
                    p.setUid(UUID.randomUUID().toString());
                    p.setNombre(nombre);
                    p.setApellidos(apellidos);
                    p.setCorreo(correo);
                    p.setPassword(contraseña);
                    databaseReference.child("persona").child(p.getUid()).setValue(p);
                    Toast.makeText(this, "Nuevo usuario agregado", Toast.LENGTH_SHORT).show();
                    limpiarCajas();
                }
                break;
            }
            case R.id.icon_save:{
                persona p = new persona();
                p.setUid(personSelectred.getUid());
                p.setNombre(nomP.getText().toString().trim());
                p.setApellidos(appP.getText().toString().trim());
                p.setCorreo(correoP.getText().toString().trim());
                p.setPassword(contraP.getText().toString().trim());
                databaseReference.child("persona").child(p.getUid()).setValue(p);
                Toast.makeText(this, "Usuario actualizado", Toast.LENGTH_SHORT).show();
                limpiarCajas();
                break;
            }
            case R.id.icon_delete:{
                persona d = new persona();
                d.setUid(personSelectred.getUid());
                databaseReference.child("persona").child(d.getUid()).removeValue();
                Toast.makeText(this, "Usuario eliminado", Toast.LENGTH_SHORT).show();
                limpiarCajas();
                break;
            }
            default:break;
        }
        return true;
    }

    private void limpiarCajas() {
        nomP.setText("");
        correoP.setText("");
        contraP.setText("");
        appP.setText("");
    }

    private void validacion() {
        String nombre = nomP.getText().toString();
        String apellidos = appP.getText().toString();
        String contraseña = contraP.getText().toString();
        String correo = correoP.getText().toString();

        if(nombre.equals("")){
            nomP.setError("Required");
        }
        if(apellidos.equals("")){
            appP.setError("Required");
        }
        if(contraseña.equals("")){
            contraP.setError("Required");
        }
        if(correo.equals("")){
            correoP.setError("Required");
        }

    }
}