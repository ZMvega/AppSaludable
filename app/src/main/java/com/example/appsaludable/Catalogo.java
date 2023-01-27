package com.example.appsaludable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appsaludable.Adaptadores.ProductoAdaptador;
import com.example.appsaludable.DB.DBFirebase;
import com.example.appsaludable.DB.DBHelper;
import com.example.appsaludable.Entidades.Productos;
import com.example.appsaludable.Servicios.ProductService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Catalogo extends AppCompatActivity {

    private DBHelper dbHelper;
    private DBFirebase dbFirebase;
    private ProductService productService;
    private ListView listViewProductos;
    private ArrayList<Productos> arrayProductos;
    private ProductoAdaptador productoAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        listViewProductos = (ListView) findViewById(R.id.listViewProductos);
        arrayProductos = new ArrayList<>();


        try {
            dbHelper = new DBHelper(this);
            dbFirebase = new DBFirebase();
            productService = new ProductService();
            arrayProductos = productService.cursorToArrayList(dbHelper.getProducts());

        }catch (Exception e){
            Log.e("DB Get", e.toString());
        }

        productoAdaptador = new ProductoAdaptador(this, arrayProductos);
        listViewProductos.setAdapter(productoAdaptador);

        dbFirebase.getProducts(productoAdaptador, arrayProductos);
        //***Creacion de productos
        /*Productos producto1 = new Productos(productService.imageViewToByte( R.drawable.bandas), "Bandas Elasticas", "Incrementa tu fuerza y estabilidad", 100000);
        Productos producto2 = new Productos(2, R.drawable.colchoneta, "Colchoneta", "Realiza estiramientos y otros ejercicios", 30000);
        Productos producto3 = new Productos(3, R.drawable.mancuernas, "Mancuernas", "Complementa rutinas de entrenamiento de fuerza", 120000);
        Productos producto4 = new Productos(4, R.drawable.bancofuerza, "Banco Fuerza", "Ideal para realizar rutinas de fuerza y aumento muscular.", 400000);
        Productos producto5 = new Productos(5, R.drawable.agua, "Agua", "Hidratate en tus entrenamientos + vitaminas", 3000);
        Productos producto6 = new Productos(6, R.drawable.balon, "Balon fitball", "Implemento muy versátil usado en muchos tipos de entrenamientos.", 40000);
        Productos producto7 = new Productos(7, R.drawable.barra, "Barra fit", "Complementa tu rutina con la barra Body Bar", 70000);
        Productos producto8 = new Productos(8, R.drawable.cubo, "Cubo", "Ideal para adaptar posturas", 15000);
        Productos producto9 = new Productos(9, R.drawable.asesoria, "Asesoria Nutricionista", "Incrementa tu plan con asesoria personalizada", 150000);
        Productos producto10 = new Productos(10, R.drawable.deportologa, "Medicina especializada", "Incrementar tus capacidades y salud", 200000);

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);
        arrayProductos.add(producto5);
        arrayProductos.add(producto6);
        arrayProductos.add(producto7);
        arrayProductos.add(producto8);
        arrayProductos.add(producto9);
        arrayProductos.add(producto10);

        int productosItem = R.layout.productos_item;*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAdd:
                Intent intent = new Intent(getApplicationContext(), ProductForm.class);
                startActivity(intent);
                return true;
            case R.id.itemFavorite:
                Toast.makeText(getApplicationContext(), "Favoritos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemShare:
                Toast.makeText(getApplicationContext(), "Compartir", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}