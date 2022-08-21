package com.br.ceep.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.br.ceep.R;
import com.br.ceep.controller.NotaDAO;
import com.br.ceep.model.Nota;

public class FormularioNotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_nota);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario_salva_nota, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_formulario_ic_salva){
            EditText titulo_nota = findViewById(R.id.formulario_nota_titulo);
            EditText descricao_nota = findViewById(R.id.formulario_nota_descricao);
            Nota notaCriada = new Nota(titulo_nota.getText().toString(),
                    descricao_nota.getText().toString());
            new NotaDAO().insere(notaCriada);
            Intent resultadoInsercao = new Intent();
            resultadoInsercao.putExtra("nota",notaCriada);
            setResult(2,resultadoInsercao);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}