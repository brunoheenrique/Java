package com.br.ceep.views.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.br.ceep.R;
import com.br.ceep.controller.NotaDAO;
import com.br.ceep.model.Nota;
import com.br.ceep.views.recycler.adapter.ListaNotasAdapter;

import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    private ListaNotasAdapter adapter;
    private List<Nota> todasNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        todasNotas = notasDeExemplo();
        configuraRecyclerView(todasNotas);

        TextView InsereNota = findViewById(R.id.lista_notas_insere_nota);
        InsereNota.setOnClickListener(view -> {
            Intent iniciaFormularioNota = new Intent(ListaNotasActivity.this,
                    FormularioNotaActivity.class);
            startActivity(iniciaFormularioNota);
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        NotaDAO dao = new NotaDAO();
        todasNotas.clear();
        todasNotas.addAll(dao.todos());
        adapter.notifyDataSetChanged();
        super.onResume();
    }

    private List<Nota> notasDeExemplo() {
        NotaDAO dao = new NotaDAO();
        dao.insere(new Nota("Primeira nota do cadernin", "Nota"),
                new Nota("Segunda nota do cadernin", "Nota"));
        return dao.todos();
    }

    private void configuraRecyclerView(List<Nota> todasNotas) {
        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);
        configuraAdapter(todasNotas, listaNotas);
    }

    private void configuraAdapter(List<Nota> notas, RecyclerView listaNotas) {
        adapter = new ListaNotasAdapter(this, notas);
        listaNotas.setAdapter(adapter);
    }
}