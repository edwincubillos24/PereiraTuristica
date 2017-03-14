package com.edwinacubillos.pereiraturistica;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaActivity extends AppCompatActivity {

  //  String[] parques = new String[] {"Bolivar", "La Libertad", "El Lago", "La Rebeca"};
    private Lista_Entrada[] datos = new Lista_Entrada[] {
          new Lista_Entrada(R.drawable.bolivar, "Parque de Bolivar", "Parque Principal de la ciudad", "Cra 8 Cll 18"),
          new Lista_Entrada(R.drawable.lago, "Parque El Lago", "Cuenta con un gran lago", "Cra 8 Cll 21"),
          new Lista_Entrada(R.drawable.libertad, "Parque de la Libertad", "Representa la libertad", "Cra 8 Cll 14"),
          new Lista_Entrada(R.drawable.rebeca, "Parque La Rebeca", "Parque de la circunvalar", "Av. Circunvalar")};

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        list = (ListView) findViewById(R.id.list);

        Adapter adapter = new Adapter(this, datos);
  //      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, parques);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = ( (Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT).show();

                Intent  intent = new Intent(ListaActivity.this, HotelesActivity.class);
                startActivity(intent);
            }
        });
    }

    class Adapter extends ArrayAdapter<Lista_Entrada>{

        public Adapter(@NonNull Context context, Lista_Entrada[] datos) {
            super(context, R.layout.list_item, datos);
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item, null);

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.tDescrip);
            descrip.setText(datos[position].getDescrip());

            TextView direc = (TextView) item.findViewById(R.id.tDirec);
            direc.setText(datos[position].getDirec());

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());
            return item;
        }
    }
}
