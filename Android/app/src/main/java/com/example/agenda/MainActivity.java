package com.example.agenda;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(this, "Olá Pacero!", Toast.LENGTH_LONG).show();
        TextView aluno = new TextView(createContext(this));
        aluno.setText("Salve Pacero");
        setContentView(aluno);

    }
    private Context createContext(MainActivity mainActivity) {
        return mainActivity;
    }
}
