package com.example.appsaludable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    public TextView textTraido, textPeso, textEstatura;
    public Button btnCalcular, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnCalcular =(Button) findViewById(R.id.btnCalcular);
        btnVolver =(Button) findViewById(R.id.btnVolver);
        textPeso=(TextView) findViewById(R.id.textPeso);
        textEstatura =(TextView) findViewById(R.id.textEstatura);
        textTraido=(TextView) findViewById(R.id.textTraido);

        textTraido=(TextView) findViewById(R.id.textTraido);
        Intent intent2= getIntent();
        String title= intent2.getStringExtra("title");
        textTraido.setText(title);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainActivity3.class);
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