package com.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.AlunoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de alunos";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);

        configuraFabNovoAluno();
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_botao_novo_aluno);
        botaoNovoAluno.setOnClickListener(view ->
                abreFormularioAlunoActivity()
        );
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(ListaAlunoActivity.this,
                FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        AlunoDAO dao = new AlunoDAO();
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,dao.todos()));
    }
}
