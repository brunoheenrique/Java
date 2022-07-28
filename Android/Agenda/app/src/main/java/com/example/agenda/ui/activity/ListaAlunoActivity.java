package com.example.agenda.ui.activity;

import static android.widget.AdapterView.AdapterContextMenuInfo;
import static com.example.agenda.ui.activity.ConstantActivities.CHAVE_ALUNO;

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
import com.example.agenda.model.Aluno;
import com.example.agenda.ui.ListaAlunosView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de alunos";
    private final ListaAlunosView listaAlunosView= new ListaAlunosView(null);

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
        listaAlunosView.atualizarAlunos();
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        listaAlunosView.configuraAdapter(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
    }

    @Override
    public boolean onContextItemSelected(@NonNull  MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.activity_lista_alunos_menu_remover){
            listaAlunosView.confirmaRemocao(item);
        }else if(itemId == R.id.activity_lista_alunos_menu_editar){
            AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) item.getMenuInfo();
            Aluno alunoEscolhido = (Aluno) listaAlunosView.adapter.getItem(menuInfo.position);
            abreFormularioModoEditaAluno(alunoEscolhido);
        }
        return super.onContextItemSelected(item);
    }

    private void abreFormularioModoEditaAluno(Aluno aluno) {
        Intent vaiParaFormularioActivity = new Intent(ListaAlunoActivity.this,
                FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioActivity);
    }


}
