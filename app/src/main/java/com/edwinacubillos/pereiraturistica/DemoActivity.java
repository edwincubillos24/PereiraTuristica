package com.edwinacubillos.pereiraturistica;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DemoActivity extends AppCompatActivity {

    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        HotelUnoFragment fragment =  new HotelUnoFragment();
        ft.add(android.R.id.content, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        ft = fm.beginTransaction();

        switch (id){
            case R.id.mfrag1:
                HotelUnoFragment frag = new HotelUnoFragment();
                ft.replace(android.R.id.content, frag).commit();
                break;
            case R.id.mfrag2:
                HotelDosFragment frag2 = new HotelDosFragment();
                ft.replace(android.R.id.content, frag2).commit();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
