package com.example.appsaludable.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsaludable.Catalogo;
import com.example.appsaludable.Entidades.Productos;
import com.example.appsaludable.Info;
import com.example.appsaludable.R;

import java.util.ArrayList;

public class ProductoAdaptador extends BaseAdapter {

    //Se define primer un contexto - es la pantalla desde donde se va a usar
    private Context context;
    private ArrayList<Productos> arrayProductos;


    public ProductoAdaptador(Context context, ArrayList<Productos> arrayProductos) {
        this.context = context;
        this.arrayProductos = arrayProductos;
    }



    @Override
    public int getCount() {
        return arrayProductos.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    //Aqui se devuelve la vista , este es el mas importante
    public View getView(int i, View view, ViewGroup viewGroup) {


        LayoutInflater layoutInflater= LayoutInflater.from(this.context);
        view=layoutInflater.inflate(R.layout.productos_item, null);



        ImageView imageProducto =(ImageView) view.findViewById(R.id.imageProducto);
        TextView textNombreProducto =(TextView) view.findViewById(R.id.textNombreProducto);
        TextView textDescripcionProducto =(TextView) view.findViewById(R.id.textDescripcionProducto);
        TextView textPrecioProducto =(TextView) view.findViewById(R.id.textPrecioProducto);



        Productos productos= arrayProductos.get(i);

        //byte[] image = productos.getImagen();
        //Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);

        //imageProducto.setImageBitmap(bitmap);
        textNombreProducto.setText(productos.getNombre());
        textDescripcionProducto.setText(productos.getDescripción());
        textPrecioProducto.setText(String.valueOf(productos.getPrecio()));
        imageProducto.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context.getApplicationContext(), Info.class);
                intent.putExtra("nombre", productos.getNombre());
                intent.putExtra("descripcion", productos.getDescripción());
                intent.putExtra("precio", productos.getPrecio());
                //intent.putExtra("image", productos.getImagen());
                context.startActivity(intent);
                //Toast.makeText(context.getApplicationContext(), "Hola "+productos.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });



        return view;


    }
}
