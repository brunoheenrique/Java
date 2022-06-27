package com.example.agenda.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista de Alunos");
        List<String> alunos = new ArrayList<>(
                Arrays.asList("Bruno", "João", "Matheus", "Felipe","Ezequias"));
        ListView listaDeAlunos = findViewById(R.id.activity_main_listaDeAlunos);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,alunos));
    }
}
