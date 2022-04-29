package models;

abstract class Conta {
    protected int saldo = 0;
    protected int agencia;
    protected String id;
    
    abstract protected void sacar (int valor);

    abstract protected void depositar (int valor);
       
}

 