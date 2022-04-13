package models;

public class ContaCorrente extends Conta {
    private int saldo = 0;
    
    ContaCorrente(int agencia, String id){
       super();
    }
    
    int getSaldo (int valor){
        valor = this.saldo;
        return valor;
    }
}
