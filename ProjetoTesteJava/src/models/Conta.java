package models;

public class Conta {
    protected int saldo = 0;
    protected int agencia;
    protected String id;
    
    public Conta (int agencia, String id) {
        this.agencia = agencia;
        this.id = id;
    }
    protected void sacar (int valor){
        if(this.saldo < valor){
            System.out.println("saldo em conta menor do que valor solicitado para saque");
            return;
        } else {
            this.saldo -= valor;   
        }
    }
    
    protected void depositar (int valor){
       this.saldo += valor; 
    }
       
}

 