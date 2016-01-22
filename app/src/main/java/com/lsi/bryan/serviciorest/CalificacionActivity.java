package com.lsi.bryan.serviciorest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;

public class CalificacionActivity extends Activity {
    private Button btnAtras;
    private GridView grilla;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion);

        btnAtras = (Button) findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresarPagina(v);
            }
        });

        grilla = (GridView) findViewById(R.id.gridView);
        grilla.setAdapter((ListAdapter) adapter);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    public void regresarPagina(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
