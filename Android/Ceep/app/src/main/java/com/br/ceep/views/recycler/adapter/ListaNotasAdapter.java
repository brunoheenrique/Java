package com.br.ceep.views.recycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.ceep.R;
import com.br.ceep.model.Nota;

import java.util.List;

public class ListaNotasAdapter extends RecyclerView.Adapter {

    private List<Nota> notas;
    private Context context;

    public ListaNotasAdapter(Context context, List<Nota> notas){
        this.context=context;
        this.notas = notas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_nota, parent, false);
        return new NotaViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Nota nota = notas.get(position);
        TextView titulo = holder.itemView.findViewById(R.id.item_nota_titulo);
        titulo.setText(nota.getTitulo());
        TextView descricao = holder.itemView.findViewById(R.id.item_nota_descricao);
        descricao.setText(nota.getDescricao());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class NotaViewHolder extends RecyclerView.ViewHolder {

        public NotaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}