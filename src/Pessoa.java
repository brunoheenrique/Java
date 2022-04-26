package src;

public class Pessoa{
    protected String nome;
    protected String idade;
    protected Long CPF;
    
    abstract void getNome(){
        System.out.println(this.nome);
    }
    
}
