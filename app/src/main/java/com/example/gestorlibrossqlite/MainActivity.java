package com.example.gestorlibrossqlite;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnIrLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIrLibros = findViewById(R.id.btnIrLibros);
        btnIrLibros.setOnClickListener(v -> {
            startActivity(new Intent(this, LibroActivity.class));
        });
    }
}
