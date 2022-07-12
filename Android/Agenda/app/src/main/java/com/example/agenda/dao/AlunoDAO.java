package com.example.agenda.dao;

import androidx.annotation.Nullable;

import com.example.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    private int contadorDeIDs = 1;

    public void salvar(Aluno aluno) {
        aluno.setId(contadorDeIDs);
        alunos.add(aluno);
        incrementaID();
    }

    private void incrementaID() {
        contadorDeIDs++;
    }

    public void edita(Aluno aluno){
        Aluno alunoEncontrado = buscaAlunoPeloID(aluno);
        if(alunoEncontrado != null){
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno,aluno);
        }
    }

    @Nullable
    private Aluno buscaAlunoPeloID(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getId() == aluno.getId()) {
                return a;
            }
        }
        return null;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void remover(Aluno aluno) {
        Aluno alunoDevolvido = buscaAlunoPeloID(aluno);
        if(alunoDevolvido != null){
            alunos.remove(alunoDevolvido);
        }
    }
}
