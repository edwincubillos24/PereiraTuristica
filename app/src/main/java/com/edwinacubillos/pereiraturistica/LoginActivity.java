package com.edwinacubillos.pereiraturistica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsername, eContrasena;
    Button bIniciar;
    TextView tRegistrese;
    String username, password, correo;
    Intent intent;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        username = prefs.getString("username","noname");
        password = prefs.getString("password","nopass");
        correo = prefs.getString("correo","nocorreo");

        Log.d("login",String.valueOf(prefs.getInt("login",-1)));
        Log.d("username", username);
        Log.d("password", password);
        Log.d("correo", correo);

        if ( prefs.getInt("login",-1) == 1) { // 1 hay alguien loggeado -1 no hay
            intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        eUsername = (EditText) findViewById (R.id.eUsername);
        eContrasena = (EditText) findViewById(R.id.eContrasena);
        bIniciar = (Button) findViewById(R.id.bIniciar);
        tRegistrese = (TextView) findViewById(R.id.tRegistrese);

        tRegistrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivityForResult(intent,1234);
            }
        });

        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eUsername.getText().toString().equals(username) &&
                        eContrasena.getText().toString().equals(password)) {

                    editor.putInt("login",1);
                    editor.commit();

                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username",username);
                    intent.putExtra("correo",correo);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK ){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("contrasena");
            correo = data.getExtras().getString("correo");

            editor.putString("username",username);
            editor.putString("password",password);
            editor.putString("correo",correo);
            editor.commit();

            Log.d("username",username);
        } else {
            if (requestCode == 1234 && resultCode == RESULT_CANCELED){
                Toast.makeText(this, "ERROR en Registro", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
