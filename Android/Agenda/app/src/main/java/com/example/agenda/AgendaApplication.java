package com.example.agenda;

import android.app.Application;

import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AlunoDAO dao = new AlunoDAO();
        dao.salvar(new Aluno("Bruno", "123123", "bruno@teste.com"));
        dao.salvar(new Aluno("Jebises", "123123123", "jefrio@teste.com"));
    }
}
