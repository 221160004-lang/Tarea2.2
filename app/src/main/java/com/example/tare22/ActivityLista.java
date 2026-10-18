package com.example.tare22;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ActivityLista extends AppCompatActivity {

    private static final String TAG = "CicloVida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Log.d(TAG, "ListaActivity: onCreate");

        RecyclerView rv = findViewById(R.id.rvContactos);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ContactoAdapter(confirmacionActivity.listaContactos));

        Button btnAgregarOtro = findViewById(R.id.btnAgregarOtro);
        btnAgregarOtro.setOnClickListener(v -> finish());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ListaActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ListaActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ListaActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ListaActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ListaActivity: onDestroy");
    }
}