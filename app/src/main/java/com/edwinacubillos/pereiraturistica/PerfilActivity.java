package com.edwinacubillos.pereiraturistica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PerfilActivity extends AppCompatActivity {

    String username, correo;
    TextView tUsername, tCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tUsername = (TextView) findViewById(R.id.tUsername);
        tCorreo = (TextView) findViewById(R.id.tCorreo);

        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        correo = extras.getString("correo");

        tUsername.setText(username);
        tCorreo.setText(correo);

    }
}
