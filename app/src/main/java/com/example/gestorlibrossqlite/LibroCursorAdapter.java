package com.example.gestorlibrossqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class LibroCursorAdapter extends CursorAdapter {
    public LibroCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.fila_libro, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtCodigo = view.findViewById(R.id.txtCodigo);
        TextView txtNombre = view.findViewById(R.id.txtNombre);
        TextView txtAutor = view.findViewById(R.id.txtAutor);
        TextView txtEditorial = view.findViewById(R.id.txtEditorial);

        txtCodigo.setText(cursor.getString(cursor.getColumnIndexOrThrow("codigo")));
        txtNombre.setText(cursor.getString(cursor.getColumnIndexOrThrow("nombre")));
        txtAutor.setText(cursor.getString(cursor.getColumnIndexOrThrow("autor")));
        txtEditorial.setText(cursor.getString(cursor.getColumnIndexOrThrow("editorial")));
    }

}
