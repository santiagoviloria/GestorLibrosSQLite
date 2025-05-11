package com.example.gestorlibrossqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class LibroController {
    private BaseDatos baseDatos;

    public LibroController(Context context) {
        baseDatos = new BaseDatos(context);
    }

    public long insertarLibro(Libro libro) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("codigo", libro.getCodigo());
        values.put("nombre", libro.getNombre());
        values.put("autor", libro.getAutor());
        values.put("editorial", libro.getEditorial());
        return db.insert("libro", null, values);
    }

    public int eliminarLibro(String codigo) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        return db.delete("libro", "codigo=?", new String[]{codigo});
    }

    public int actualizarLibro(Libro libro) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", libro.getNombre());
        values.put("autor", libro.getAutor());
        values.put("editorial", libro.getEditorial());
        return db.update("libro", values, "codigo=?", new String[]{libro.getCodigo()});
    }


    public Cursor obtenerCursor() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();
        return db.rawQuery("SELECT * FROM libro", null);
    }
}
