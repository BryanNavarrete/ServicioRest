package com.lsi.bryan.serviciorest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import modelo.Nota;
import modelo.Periodo;


public class MainActivity extends Activity{
    ListAdapter adapter;
    String tag_json_arry = "jarray_req";
    private Button btnConsultar;
    private EditText txtCedula;
    private Spinner spnPeriodos;
    private Periodo periodo;
    private Nota nota;
    //"http://lisrestful.azurewebsites.net/api/notas?cod_estudiante="+codigo+"&cod_lectivo="+periodo+""
    private static final String URL_Periodos = "http://lisrestful.azurewebsites.net/api/periodoLectivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCedula = (EditText)findViewById(R.id.txtCedula);
        spnPeriodos = (Spinner) findViewById(R.id.spnPeriodos);
        btnConsultar = (Button)findViewById(R.id.btnConsultar);
        spnPeriodos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                periodo.setCod_periodo(spnPeriodos.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                periodo.setCod_periodo(null);
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarCalificaciones(v);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void consultarCalificaciones(View view){
        nota.setCod_estudiante(txtCedula.getText().toString());
        nota.setCod_lectivo(periodo.getCod_periodo());

        //Validacione de la Cédula y Periodo
        if (!TextUtils.isEmpty(nota.getCod_estudiante())&&!TextUtils.isEmpty(nota.getCod_estudiante())){
            Intent intent = new Intent(this, CalificacionActivity.class);
            startActivity(intent);
        }else{
            Toast toast1 = Toast.makeText(getApplicationContext(),"La Cédula y el Periodo es obligatoria", Toast.LENGTH_SHORT);
            toast1.show();
        }
    }
}
