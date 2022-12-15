package com.lsd.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import android.content.Intent
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ActivityListaPostulantes extends AppCompatActivity {

    ArrayList<Postulante> listaPostulantes;
    ArrayList<Postulante> listaPostulantes2;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulantes);

        listaPostulantes=new ArrayList<Postulante>();



        ArrayList <String> array;
        recycler = (RecyclerView) findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Context contexto = this;
        Helper1 helper=new Helper1();
        array=helper.leer(contexto);
        String a="";
        String b="";
        String c="";
        String d="";
        String e="";
        String f="";
        Postulante pos=new Postulante(a,b,c,d,e,f);
        for (int i=0; i<array.size();i++){
            Log.i("","dsad"+array.get(i));
            int inicio=array.get(i).indexOf(":");
            int inicio1=array.get(i).indexOf("*");

            int y =array.get(i).length();
            int fin=array.get(i).indexOf(":", inicio+1);
            int fin1=array.get(i).indexOf("*", inicio1+1);

            int fin2=array.get(i).indexOf(":", fin+1);
            int fin3=array.get(i).indexOf("*", fin1+1);

            int fin4=array.get(i).indexOf(":", fin2+1);
            int fin5=array.get(i).indexOf("*", fin3+1);

            int fin6=array.get(i).indexOf(":", fin4+1);
            int fin7=array.get(i).indexOf("*", fin5+1);

            int fin8=array.get(i).indexOf(":", fin6+1);
            int fin9=array.get(i).indexOf("*", fin7+1);


            //int inicio2=array.get(i).indexOf()
            a= array.get(i).substring(inicio+1,inicio1);
            b= array.get(i).substring(fin+1,fin1);
            c= array.get(i).substring(fin2+1, fin3);
            d= array.get(i).substring(fin4+1, fin5);
            e= array.get(i).substring(fin6+1, fin7);
            f= array.get(i).substring(fin8+1, y-1);
            listaPostulantes.add(new Postulante(a,b,c,d,e,f));
        }

        Log.i("","veamos "+listaPostulantes.get(0).getNombre());
        Log.i("","veamos "+listaPostulantes.get(0).getApellidoP());
        Log.i("","veamos "+listaPostulantes.get(0).getApellidoM());
        Log.i("","veamos "+listaPostulantes.get(0).getFechaN());
        Log.i("","veamos "+listaPostulantes.get(0).getColegio());
        Log.i("","veamos "+listaPostulantes.get(0).getCarrera());


        //pasa la lista de postulantes
        AdaptadorPostulantes adapter= new AdaptadorPostulantes(listaPostulantes);
        recycler.setAdapter(adapter);
    }
}