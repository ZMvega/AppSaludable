package com.example.appsaludable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private TextView textTraido, textPeso, textEstatura;
    private Button btnCalcular, btnVolver;
    private EditText editTextPeso, editTextEstatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnCalcular =(Button) findViewById(R.id.btnCalcular);
        btnVolver =(Button) findViewById(R.id.btnVolver);
        textPeso=(TextView) findViewById(R.id.textPeso);
        textEstatura =(TextView) findViewById(R.id.textEstatura);
        textTraido=(TextView) findViewById(R.id.textTraido);
        editTextPeso=(EditText) findViewById(R.id.editTextPeso);
        editTextEstatura=(EditText) findViewById(R.id.editTextEstatura);

        textTraido=(TextView) findViewById(R.id.textTraido);
        Intent intent2= getIntent();
        String title= intent2.getStringExtra("title");
        textTraido.setText(title);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainActivity4.class);
                double peso= Double.parseDouble(editTextPeso.getText().toString().trim());
                double estatura= Double.parseDouble(editTextEstatura.getText().toString().trim());
                double resultado= peso/(estatura*estatura/(100*100));
                intent.putExtra("resultado", resultado);
                Toast.makeText(getApplicationContext(),String.valueOf(resultado),Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });



        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });



    }
}