package com.br.ceep.views.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.br.ceep.R;
import com.br.ceep.controller.NotaDAO;
import com.br.ceep.model.Nota;
import com.br.ceep.views.recycler.adapter.ListaNotasAdapter;

import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        List<Nota> todasNotas = notasDeExemplo();
        configuraRecyclerView(todasNotas);
    }

    private List<Nota> notasDeExemplo() {
        NotaDAO dao = new NotaDAO();
        dao.insere(new Nota("Primeira nota do cadernin", "Ah vai se lasca n quero saber"),
                new Nota("Segunda nota do cadernin", "Man, tu é insistente na parada"));
        return dao.todos();
    }

    private void configuraRecyclerView(List<Nota> todasNotas) {
        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);
        configuraAdapter(todasNotas, listaNotas);
    }

    private void configuraAdapter(List<Nota> notas, RecyclerView listaNotas) {
        listaNotas.setAdapter(new ListaNotasAdapter(this, notas));
    }
}