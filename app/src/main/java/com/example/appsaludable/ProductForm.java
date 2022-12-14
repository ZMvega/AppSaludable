package com.example.appsaludable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.appsaludable.DB.DBFirebase;
import com.example.appsaludable.DB.DBHelper;
import com.example.appsaludable.Entidades.Productos;
import com.example.appsaludable.Servicios.ProductService;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProductForm extends AppCompatActivity {

    private DBHelper dbHelper;
    private DBFirebase dbFirebase;
    private ProductService productService;
    private Button btnProductForm;
    private ImageView imgProductForm;
    private EditText editNameProductForm, editDescriptionProductForm, editPriceProductForm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_form);

        btnProductForm = (Button) findViewById(R.id.btnProductForm);
        imgProductForm = (ImageView) findViewById(R.id.imgProductForm);
        editNameProductForm = (EditText) findViewById(R.id.editNameProductForm);
        editDescriptionProductForm = (EditText) findViewById(R.id.editDescriptionProductForm);
        editPriceProductForm = (EditText) findViewById(R.id.editPriceProductForm);

        try {
            dbHelper = new DBHelper(this);
            dbFirebase = new DBFirebase();
            productService = new ProductService();
        } catch (Exception e){
            Log.e("Error DB", e.toString());
        }
        btnProductForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Productos producto = new Productos(
                        editNameProductForm.getText().toString(),
                        editDescriptionProductForm.getText().toString(),
                        Integer.parseInt(editPriceProductForm.getText().toString().trim()),
                        ""
                        //productService.imageViewToByte(imgProductForm)
                );
                //dbHelper.insertProduct(producto);
                dbFirebase.insertProduct(producto);

                Intent intent = new Intent(getApplicationContext(), Catalogo.class);
                startActivity(intent);
            }
        });
    }
}