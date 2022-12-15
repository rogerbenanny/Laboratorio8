package com.lsd.laboratorio3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

import kotlin.jvm.internal.Intrinsics;

public class ActivityPostulateRegis extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);

         EditText nombre = findViewById(R.id.etName);
         EditText apellidoP = findViewById(R.id.etLastNameP);
         EditText apellidoM = findViewById(R.id.etLastNameM);
         EditText fechaN = findViewById(R.id.etDate);
         EditText colegio = findViewById(R.id.etColegio);
         EditText carrera = findViewById(R.id.etCarrera);
        Button registrar = findViewById(R.id.btnRegistrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a1 = nombre.getText().toString();
                String a2 = apellidoP.getText().toString();
                String a3 = apellidoM.getText().toString();
                String a4 = fechaN.getText().toString();
                String a5 = colegio.getText().toString();
                String a6 = carrera.getText().toString();

                Postulante po = new Postulante(a1,a2,a3,a4,a5,a6);


                //registerForActivityResult(po);


            }
        });
    }

    public final void registerForActivityResult(@NotNull Postulante postulante) {
        Intrinsics.checkNotNullParameter(postulante, "postulante");
        Intent intent = new Intent((Context)this, ActivityMenu.class);
        intent.putExtra("objetoPostulante", (Serializable)postulante);
        this.startActivity(intent);
    }
}
