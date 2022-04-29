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
    
    @Override
    public void sacar(int valor){
        if(super.saldo < 0){
            System.out.println("Valor solicitado menor do que o saldo atual");
        }else{
            super.saldo-=valor;
        }
    }
    
    @Override
    
  
}
