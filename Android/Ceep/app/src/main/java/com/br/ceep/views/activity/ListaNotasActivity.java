package com.br.ceep.views.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.br.ceep.R;
import com.br.ceep.controller.NotaDAO;
import com.br.ceep.model.Nota;
import com.br.ceep.views.adapter.ListaNotasAdapter;

import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        ListView listaNotas = findViewById(R.id.lista_notas_listview);

        NotaDAO dao = new NotaDAO();
        for(int i = 1; i<=10000;i++){
            dao.insere(new Nota("Titulo "+ i ,"Vai a merda pacero " + i + "x"));
        }
        List<Nota> todasNotas = dao.todos();

        listaNotas.setAdapter(new ListaNotasAdapter(this,todasNotas));

    }
}