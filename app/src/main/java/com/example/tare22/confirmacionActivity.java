package com.example.tare22;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class confirmacionActivity extends AppCompatActivity {

    private static final String TAG = "CicloVida";

    public static ArrayList<Contacto> listaContactos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        Log.d(TAG, "ConfirmacionActivity: onCreate");

        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvCorreo = findViewById(R.id.tvCorreo);
        TextView tvTelefono = findViewById(R.id.tvTelefono);
        TextView tvTipo = findViewById(R.id.tvTipo);
        Button btnVolver = findViewById(R.id.btnVolver);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);

        Intent recibido = getIntent();
        String nombre = recibido.getStringExtra("nombre");
        String correo = recibido.getStringExtra("correo");
        String telefono = recibido.getStringExtra("telefono");
        String tipo = recibido.getStringExtra("tipo");

        tvNombre.setText("Nombre: " + nombre);
        tvCorreo.setText("Correo: " + correo);
        tvTelefono.setText("Teléfono: " + telefono);
        tvTipo.setText("Tipo: " + tipo);

        btnVolver.setOnClickListener(v -> finish());

        btnConfirmar.setOnClickListener(v -> {
            listaContactos.add(new Contacto(nombre, correo, telefono, tipo));
            startActivity(new Intent(confirmacionActivity.this, ActivityLista.class));
            finish();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ConfirmacionActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ConfirmacionActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ConfirmacionActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ConfirmacionActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ConfirmacionActivity: onDestroy");
    }
}