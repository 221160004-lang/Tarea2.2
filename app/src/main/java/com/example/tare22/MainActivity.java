package com.example.tare22;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicloVida";

    private EditText etNombre, etCorreo, etTelefono;
    private RadioGroup rgTipo;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity: onCreate");

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etTelefono = findViewById(R.id.etTelefono);
        rgTipo = findViewById(R.id.rgTipo);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v -> {
            if (validar()) {
                RadioButton rb = findViewById(rgTipo.getCheckedRadioButtonId());

                Intent intent = new Intent(MainActivity.this, confirmacionActivity.class);
                intent.putExtra("nombre", etNombre.getText().toString().trim());
                intent.putExtra("correo", etCorreo.getText().toString().trim());
                intent.putExtra("telefono", etTelefono.getText().toString().trim());
                intent.putExtra("tipo", rb.getText().toString());
                startActivity(intent);
            }
        });
    }

    private boolean validar() {
        boolean ok = true;

        String nombre = etNombre.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String telefono = etTelefono.getText().toString().trim();

        if (nombre.isEmpty()) {
            etNombre.setError("El nombre es obligatorio");
            ok = false;
        }

        if (correo.isEmpty()) {
            etCorreo.setError("El correo es obligatorio");
            ok = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.setError("Correo no válido");
            ok = false;
        }

        if (telefono.isEmpty()) {
            etTelefono.setError("El teléfono es obligatorio");
            ok = false;
        } else if (!telefono.matches("\\d{8}")) {
            etTelefono.setError("Debe tener exactamente 8 dígitos");
            ok = false;
        }

        if (rgTipo.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Selecciona un tipo de contacto", Toast.LENGTH_SHORT).show();
            ok = false;
        }

        return ok;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy");
    }
}