package src;

public class Pessoa{
    protected String nome;
    protected long idade;
    
    protected void getNome(){
        System.out.println(this.nome);
    }
    
    protected void getIdade(){
        System.out.println(this.idade);
    }
}
