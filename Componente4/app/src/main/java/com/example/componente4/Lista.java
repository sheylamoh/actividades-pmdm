package com.example.componente4;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class Articulos extends RecyclerView.Adapter<ArticuloViewHolder> implements View.OnClickListener
{
    private final ArrayList<Articulo> lista;

    private View.OnClickListener listener;

    Articulos(ArrayList<Articulo> datos) {
        this.lista = datos;
    }

    @NonNull
    @Override
    public ArticuloViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.articulo, viewGroup, false);
        itemView.setOnClickListener(this);
        ArticuloViewHolder ovh = new ArticuloViewHolder(itemView);

        return ovh;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticuloViewHolder holder, int position)
    {
        Articulo item = lista.get(position);
        holder.bindArticulo(item);
    }

    @Override
    public int getItemCount()
    {
        return lista.size();
    }
    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onClick(View view)
    {
        if(listener != null)
            listener.onClick(view);
    }
}
class ArticuloViewHolder extends RecyclerView.ViewHolder
{
    private TextView nombre;

    public ArticuloViewHolder(View itemView)
    {
        super(itemView);

        nombre = (TextView)itemView.findViewById(R.id.textViewNombre);
    }

    @SuppressLint("ResourceAsColor")


    public void bindArticulo(Articulo articulo)
    {
        nombre.setText(articulo.getNombre());

        if(articulo.estaComprado())
            nombre.setBackgroundColor(R.color.purple_500);
        else
            nombre.setBackgroundColor(R.color.purple_200);
    }
}
