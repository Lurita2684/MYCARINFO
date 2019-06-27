package com.example.mycarinfo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements NombreFragment.OnFragmentInteractionListener {

    EditText etDatos;

    private ApplicationPreferences appPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDatos = findViewById(R.id.etNombre);

        appPref.init(getApplicationContext());
        ApplicationPreferences.init(getApplicationContext());

        ApplicationPreferences.saveDatos();

        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        Fragment fragment = new NombreFragment();
        FT.add(R.id.fragment_main, fragment);
        FT.commit();
    }

    @Override
    public void onClickButton() {

    }
}
