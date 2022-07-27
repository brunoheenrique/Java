package com.example.agenda;

import android.app.Application;

import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosTeste();
    }

    private void criaAlunosTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salvar(new Aluno("Bruno", "344779233", "bruno@teste.com"));
        dao.salvar(new Aluno("Josimar", "123462143", "jefrio@teste.com"));
    }
}
