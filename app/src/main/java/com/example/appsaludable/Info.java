package com.example.appsaludable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    private TextView textNombreInfo, textDescripcionInfo, textPrecioInfo;
    private ImageView imageInfo;
    private Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textNombreInfo =(TextView) findViewById(R.id.textNombreInfo);
        textDescripcionInfo =(TextView) findViewById(R.id.textDescriptionInfo);
        textPrecioInfo =(TextView) findViewById(R.id.textPrecioInfo);
        imageInfo =(ImageView) findViewById(R.id.imageInfo);
        btnInfo =(Button) findViewById(R.id.btnInfo);

        Intent intentIn = getIntent();
        textNombreInfo.setText(intentIn.getStringExtra("nombre"));
        textDescripcionInfo.setText(intentIn.getStringExtra("descripcion"));
        textPrecioInfo.setText(String.valueOf(intentIn.getIntExtra("precio", 0)));
        imageInfo.setImageResource(intentIn.getIntExtra("image", 0));

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Catalogo.class);
                startActivity(intent);
            }
        });
    }
}