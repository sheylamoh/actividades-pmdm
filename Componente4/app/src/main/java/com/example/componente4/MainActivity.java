package com.example.componente4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{
    private ArrayList<Articulo> lista;
    private RecyclerView recView;
    private Button btnAñadir;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recView = (RecyclerView) findViewById(R.id.recView);
        recView.setHasFixedSize(true);

        lista = new ArrayList<Articulo>();

        final Articulos adaptador = new Articulos(lista);

        adaptador.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                lista.get(recView.getChildAdapterPosition(v)).setComprado(true);
                Toast.makeText(getBaseContext(), "estás viendo '" + lista.get(recView.getChildAdapterPosition(v)).getNombre()
                        + "'", Toast.LENGTH_SHORT).show();
            }
        });

        //recicler view
        recView.setAdapter(adaptador);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recView.setItemAnimator(new DefaultItemAnimator());

        btnAñadir = findViewById(R.id.button);
        editText = findViewById(R.id.editTextArticulo);

        btnAñadir.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                lista.add(0, new Articulo(editText.getText().toString()));
                adaptador.notifyItemInserted(1);
                Toast.makeText(getBaseContext(), "Articulo añadido tamaño de la lista: "+ adaptador.getItemCount(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}