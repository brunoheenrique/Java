package com.example.agenda.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle("Novo Aluno");
        Button botaosalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        botaosalvar.setOnClickListener(view -> Toast.makeText(FormularioAlunoActivity.this,
                "Salvou !",Toast.LENGTH_SHORT).show());
    }
}