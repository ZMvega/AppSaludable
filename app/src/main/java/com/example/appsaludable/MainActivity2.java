package com.example.appsaludable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private Button btnGuardar, btnSiguiente;
    private TextView textNombre, textApellido, textEmail;
    private EditText editTextNombre, editTextApellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnGuardar =(Button) findViewById(R.id.btnGuardar);
        btnSiguiente =(Button) findViewById(R.id.btnSiguiente);
        textNombre=(TextView) findViewById(R.id.textNombre);
        editTextNombre=(EditText) findViewById(R.id.editTextNombre);
        textApellido=(TextView) findViewById(R.id.textApellido);
        editTextApellido=(EditText) findViewById(R.id.editTextApellido);
        textEmail=(TextView) findViewById(R.id.textEmail);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainActivity3.class);
                intent.putExtra("title", editTextNombre.getText().toString() + " " +editTextApellido.getText().toString());
                startActivity(intent);
            }
        });



        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}