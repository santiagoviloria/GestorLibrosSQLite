package com.example.gestorlibrossqlite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LibroActivity extends AppCompatActivity {
    EditText txtCodigo, txtNombre, txtAutor, txtEditorial;
    Button btnGuardar, btnEliminar, btnListado;

    LibroController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro);

        txtCodigo = findViewById(R.id.txtCodigo);
        txtNombre = findViewById(R.id.txtNombre);
        txtAutor = findViewById(R.id.txtAutor);
        txtEditorial = findViewById(R.id.txtEditorial);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnListado = findViewById(R.id.btnListado);

        controller = new LibroController(this);

        btnGuardar.setOnClickListener(v -> {
            Libro libro = new Libro(
                    txtCodigo.getText().toString(),
                    txtNombre.getText().toString(),
                    txtAutor.getText().toString(),
                    txtEditorial.getText().toString()
            );
            if (controller.insertarLibro(libro) != -1) {
                Toast.makeText(this, "Libro guardado", Toast.LENGTH_SHORT).show();
            } else {
                controller.actualizarLibro(libro);
                Toast.makeText(this, "Libro actualizado", Toast.LENGTH_SHORT).show();
            }
        });

        btnEliminar.setOnClickListener(v -> {
            int filas = controller.eliminarLibro(txtCodigo.getText().toString());
            Toast.makeText(this, "Eliminado: " + filas, Toast.LENGTH_SHORT).show();
        });

        btnListado.setOnClickListener(v -> {
            startActivity(new Intent(this, ListadoLibrosActivity.class));
        });
    }
}
