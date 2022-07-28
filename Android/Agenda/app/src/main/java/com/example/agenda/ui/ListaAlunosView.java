package com.example.agenda.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.model.Aluno;
import com.example.agenda.ui.adapter.ListaAlunoAdapter;

public class ListaAlunosView {

    public final ListaAlunoAdapter adapter;
    private final AlunoDAO dao;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        adapter = new ListaAlunoAdapter(this.context);
        dao = new AlunoDAO();
    }


    public void confirmaRemocao(@NonNull final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removendo Aluno")
                .setMessage("Tem certeza que deseja remover?")
                .setPositiveButton("Sim", (dialogInterface,i) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Aluno alunoEscolhido = (Aluno) adapter.getItem(menuInfo.position);
                    removeAlunoLista(alunoEscolhido);
                })
                .setNegativeButton("Não",null)
                .show();
    }

    private void removeAlunoLista(Aluno aluno) {
        dao.remover(aluno);
        adapter.remove(aluno);
    }

    public void atualizarAlunos() {
        adapter.atualizaInfos(dao.todos());
    }

    public void configuraAdapter(@NonNull ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);
    }

}
