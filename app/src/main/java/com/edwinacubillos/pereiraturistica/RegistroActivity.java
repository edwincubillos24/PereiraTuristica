package com.edwinacubillos.pereiraturistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    EditText eRUsername, eRContrasena, eRRepContrasena, eRCorreo;
    Button bRegistrar, bCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        eRUsername = (EditText) findViewById(R.id.eRUsername);
        eRContrasena = (EditText) findViewById(R.id.eRContrasena);
        eRRepContrasena = (EditText) findViewById(R.id.eRRepContrasena);
        eRCorreo = (EditText) findViewById(R.id.eRCorreo);
        bRegistrar = (Button) findViewById(R.id.bRegistrese);
        bCancelar = (Button) findViewById(R.id.bCancelar);

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Intent intent = new Intent (RegistroActivity.this, LoginActivity.class);
                Intent intent = new Intent();
                intent.putExtra("username",eRUsername.getText().toString());
                intent.putExtra("contrasena",eRContrasena.getText().toString());
                intent.putExtra("correo",eRCorreo.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent (RegistroActivity.this, LoginActivity.class);
                Intent intent = new Intent ();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

    }
}
