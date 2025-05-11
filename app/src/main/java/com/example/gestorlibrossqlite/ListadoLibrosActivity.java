package com.example.gestorlibrossqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ListadoLibrosActivity extends AppCompatActivity {

    private LibroController libroController;
    private ListView listViewLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_libros);

        listViewLibros = findViewById(R.id.listViewLibros);
        libroController = new LibroController(this);

        cargarLibros();
    }

    private void cargarLibros() {
        Cursor cursor = libroController.obtenerCursor();
        LibroCursorAdapter adapter = new LibroCursorAdapter(this, cursor);
        listViewLibros.setAdapter(adapter);
    }
}
