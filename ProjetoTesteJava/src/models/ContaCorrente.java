package models;

public class ContaCorrente extends Conta {
    
    public ContaCorrente(){
        super();
    }
     
    public ContaCorrente(int agencia, String id){
       super();
       int saldo = super.saldo;
    }
    
    public void getSaldo (){
        System.out.println(this.saldo);
    }
    
    public void setDepositar(){
        int valor; 
    }   
    
    
    public void setSacar (int valor){
        super.sacar(valor);
    }
    
}
