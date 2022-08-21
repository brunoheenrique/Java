package com.br.ceep.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.br.ceep.R;
import com.br.ceep.model.Nota;

public class FormularioNotaActivity extends AppCompatActivity {

    public static final String CHAVE_NOTA = "nota";
    public static final int CODIGO_RESULTADO_NOTA_CRIADA = 2;

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
        if (isMenuSalvaItem(item)) {
            Nota notaCriada = criaNota();
            retornaNota(notaCriada);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void retornaNota(Nota notaCriada) {
        Intent resultadoInsercao = new Intent();
        resultadoInsercao.putExtra(CHAVE_NOTA, notaCriada);
        setResult(CODIGO_RESULTADO_NOTA_CRIADA, resultadoInsercao);
    }

    @NonNull
    private Nota criaNota() {
        EditText titulo_nota = findViewById(R.id.formulario_nota_titulo);
        EditText descricao_nota = findViewById(R.id.formulario_nota_descricao);
        return new Nota(titulo_nota.getText().toString(),
                descricao_nota.getText().toString());
    }

    private boolean isMenuSalvaItem(@NonNull MenuItem item) {
        return item.getItemId() == R.id.menu_formulario_ic_salva;
    }
}