package com.example.agenda.ui.activity;

import static android.widget.AdapterView.AdapterContextMenuInfo;
import static com.example.agenda.ui.activity.ConstantActivities.CHAVE_ALUNO;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.model.Aluno;
import com.example.agenda.ui.adapter.ListaAlunoAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaAlunoActivity extends AppCompatActivity {

    final AlunoDAO dao = new AlunoDAO();
    public static final String TITULO_APPBAR = "Lista de alunos";
    private ListaAlunoAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();
        configuraLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_alunos_menu,menu);
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_botao_novo_aluno);
        botaoNovoAluno.setOnClickListener(view ->
                abreFormularioModoInsereAluno()
        );
    }

    private void abreFormularioModoInsereAluno() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarAlunos();
    }

    private void atualizarAlunos() {
        adapter.atualizaInfos(dao.todos());
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        configuraAdapter(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
    }

    @Override
    public boolean onContextItemSelected(@NonNull final MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.activity_lista_alunos_menu_remover){
            new AlertDialog
                    .Builder(this)
                    .setTitle("Removendo Aluno")
                    .setMessage("Tem certeza que deseja remover?")
                    .setPositiveButton("Sim", (dialogInterface,i) -> {
                        AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) item.getMenuInfo();
                        Aluno alunoEscolhido = (Aluno) adapter.getItem(menuInfo.position);
                        removeAlunoLista(alunoEscolhido);
                    })
                    .setNegativeButton("Não",null)
                    .show();
        }else if(itemId == R.id.activity_lista_alunos_menu_editar){
            AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) item.getMenuInfo();
            Aluno alunoEscolhido = (Aluno) adapter.getItem(menuInfo.position);
            abreFormularioModoEditaAluno(alunoEscolhido);
        }
        return super.onContextItemSelected(item);
    }

    private void removeAlunoLista(Aluno aluno) {
        dao.remover(aluno);
        adapter.remove(aluno);
    }

    private void abreFormularioModoEditaAluno(Aluno aluno) {
        Intent vaiParaFormularioActivity = new Intent(ListaAlunoActivity.this,
                FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioActivity);
    }

    private void configuraAdapter(@NonNull ListView listaDeAlunos) {
        adapter = new ListaAlunoAdapter(this);
        listaDeAlunos.setAdapter(adapter);
    }
}
