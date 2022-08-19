package com.br.ceep.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.br.ceep.R;
import com.br.ceep.controller.NotaDAO;
import com.br.ceep.model.Nota;

import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        ListView listaNotas = findViewById(R.id.lista_notas_listview);

        NotaDAO dao = new NotaDAO();
        dao.insere(new Nota("Primeira nota","Vai a merda pacero"));

    }
}