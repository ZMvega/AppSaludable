package com.example.appsaludable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.example.appsaludable.Adaptadores.ProductoAdaptador;
import com.example.appsaludable.Entidades.Productos;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {
    private ListView listViewProductos;
    private ArrayList<Productos> arrayProductos;
    private ProductoAdaptador productoAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);


        listViewProductos = (ListView) findViewById(R.id.listViewProductos);
        arrayProductos = new ArrayList<>();

        productoAdaptador = new ProductoAdaptador(this, arrayProductos);
        listViewProductos.setAdapter(productoAdaptador);


        //***Creacion de productos
        Productos producto1 = new Productos(1, R.drawable.bandas, "Bandas Elasticas", "Incrementa tu fuerza y estabilidad", 100000);
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

        int productosItem = R.layout.productos_item;


    }

}