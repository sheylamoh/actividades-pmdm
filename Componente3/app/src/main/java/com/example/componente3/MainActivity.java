package com.example.componente3;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{


    private Opciones[] opciones;
    private RecyclerView recView;
    private Button btnAceptar;
    private CheckBox[] checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buscamos en el layout la lista RecyclerView
        recView = (RecyclerView) findViewById(R.id.recView);

        //Creo el array de opciones
        opciones = new Opciones[6];
        checkBoxes = new CheckBox[6];

        //Creo las 6 opciones
        opciones[0] = new Opciones("  Televisión", checkBoxes[0] = (CheckBox) findViewById(R.id.checkbox), R.drawable.television);
        opciones[1] = new Opciones("  Teléfono Móvil", checkBoxes[1] = (CheckBox) findViewById(R.id.checkbox), R.drawable.telefono);
        opciones[2] = new Opciones("  Tablet", checkBoxes[2] = (CheckBox) findViewById(R.id.checkbox), R.drawable.tablet);
        opciones[3] = new Opciones("  Ordenador", checkBoxes[3] = (CheckBox) findViewById(R.id.checkbox), R.drawable.pc);
        opciones[4] = new Opciones("  Portatil", checkBoxes[4] = (CheckBox) findViewById(R.id.checkbox), R.drawable.portatil);
        opciones[5] = new Opciones("  Reloj", checkBoxes[5] = (CheckBox) findViewById(R.id.checkbox), R.drawable.reloj);

        final AdaptadorOpciones adaptador = new AdaptadorOpciones(opciones);
        adaptador.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getBaseContext(), "Has hecho clic en '"
                        + opciones[recView.getChildAdapterPosition(v)].getTitulo()
                        + "'", Toast.LENGTH_SHORT).show();

                opciones[recView.getChildAdapterPosition(v)].getCheckBox().setChecked(true);
            }
        });

        recView.setAdapter(adaptador);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        btnAceptar = findViewById(R.id.button);

        // se cierra al dar  en el boton de aceptar
        /*btnAceptar.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v)
              {
                  if(opciones[0].getCheckBox().isChecked())
                  {
                      Toast toast1 =
                              Toast.makeText(getApplicationContext(),
                                      "Toast por defecto", Toast.LENGTH_SHORT);

                      toast1.show();

                  }

              }
        });*/
    }



}