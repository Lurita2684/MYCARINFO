package com.example.mycarinfo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.mycarinfo.CocheModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ApplicationPreferences {

    private static SharedPreferences mSharedPref;
    static final String KEYDATOS = "datos";


    private ApplicationPreferences() {

    }

    // Asigna la base de datps que se llama MYPREFS
    public static void init(Context context) {

        if(mSharedPref == null){
            mSharedPref = context.getSharedPreferences("MYDATA", Activity.MODE_PRIVATE);
        }
    }

    // guarda lo que hay dentro del edittext
    public static void  saveDatos(ArrayList<CocheModel> notes) {

        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(notes);
        prefsEditor.putString(KEYDATOS, json);
        prefsEditor.commit();
    }

    public static ArrayList<CocheModel> readNotes() {

        Gson gson = new Gson();
        String json = mSharedPref.getString(CocheModel, null);
        Type type = new TypeToken<ArrayList<CocheModel>>(){}.getType();
        return gson.fromJson(json, type);

    }
}
