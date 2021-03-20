package com.example.componente3;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


class AdaptadorOpciones extends RecyclerView.Adapter<OpcionViewHolder> implements View.OnClickListener{
    //Array para guardar los datos
    private final Opciones[] opciones;
    // Variable para guardar la referencia al método onClick para llamarlo cuando sea necesario
    private View.OnClickListener listener;

    AdaptadorOpciones(Opciones[] opciones) {
        this.opciones = opciones;
    }

    public OpcionViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        // Inflamos la opción con el layout correspondiente
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.opcion, viewGroup, false);

        // Establecemos el evento onClick de la opción
        itemView.setOnClickListener(this);

        // Definimos la nueva opción a partir del elemento anterior
        OpcionViewHolder ovh = new OpcionViewHolder(itemView);

        // Devolvemos ya la opción dentro la clase OpcionViewHolder
        return ovh;
    }

    @Override
    public void onBindViewHolder(@NonNull OpcionViewHolder holder, int position) {
        //Recogemos los datos de esa posicion
        Opciones item = opciones[position];

        holder.bindOpcion(item);
    }

    // Devuelve el nº de elementos de la lista
    @Override
    public int getItemCount()
    {
        return opciones.length;
    }

    // Método para establecer el evento onClick de la lista
    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    // Método que se ejecuta cuando se invoca el evento onClick
    @Override
    public void onClick(View view)
    {
        // ¡Sólo se invoca si está establecido previamente!
        if(listener != null)
            listener.onClick(view);
    }

}

//Clase que se usa para almacenar las etiquetas
class OpcionViewHolder extends RecyclerView.ViewHolder{
    private TextView titulo;
    public CheckBox checkBox;
    private ImageView icono;

    public OpcionViewHolder(View itemView){
        super(itemView);

        titulo = itemView.findViewById(R.id.textView);
        checkBox = itemView.findViewById(R.id.checkbox);
        icono = itemView.findViewById(R.id.icono);
    }

    public void bindOpcion(Opciones t)
    {
        titulo.setText(t.getTitulo());
        icono.setImageResource(t.getIcono());
    }
}