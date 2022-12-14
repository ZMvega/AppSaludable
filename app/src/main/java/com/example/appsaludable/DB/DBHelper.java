package com.example.appsaludable.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.appsaludable.Entidades.Productos;

public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase sqLiteDataBase;

    public DBHelper(Context context){
        super(context, "APP.db", null, 1);
        sqLiteDataBase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PRODUCTS("+
                "id TEXT PRIMARY KEY, "+
                "name TEXT, "+
                "description TEXT, "+
                "price TEXT, "+
                "image TEXT"+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCTS");
    }

    //METODOS CRUD
    public void insertProduct(Productos producto){
        String sql = "INSERT INTO PRODUCTS VALUES(?, ?, ?, ?, ?)";
        SQLiteStatement statement = sqLiteDataBase.compileStatement(sql);
        //statement.clearBindings();

        statement.bindString(1, producto.getId());
        statement.bindString(2, producto.getNombre());
        statement.bindString(3, producto.getDescripción());
        statement.bindString(4, String.valueOf(producto.getPrecio()));
        statement.bindString(5, producto.getImagen());

        statement.executeInsert();
    }

    public Cursor getProducts(){
        Cursor cursor = sqLiteDataBase.rawQuery("SELECT * FROM PRODUCTS", null);
        return cursor;
    }
}
