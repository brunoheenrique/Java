package src;

public class Fisica extends Pessoa {
    protected String CPF;
    
    public Fisica (String nome, long idade, String CPF){
        super();
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
    }
    
    @Override
    public void getNome(){
        System.out.println(this.nome);
    }
    
}
