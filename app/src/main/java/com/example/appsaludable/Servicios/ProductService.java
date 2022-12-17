package com.example.appsaludable.Servicios;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import com.example.appsaludable.Entidades.Productos;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ProductService {
    public byte[] imageViewToByte(ImageView imageView){
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
    /*public byte[] intToByte(Integer integer){
        Bitmap bitmap = ((BitmapDrawable) integer.byteValue()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }*/

    public ArrayList<Productos> cursorToArrayList(Cursor cursor){
        ArrayList<Productos> list = new ArrayList<>();
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()){
                Productos productos = new Productos(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        Integer.parseInt(cursor.getString(3)),
                        cursor.getString(4)
                );
                list.add(productos);
            }
        }
        return list;
    }
}
