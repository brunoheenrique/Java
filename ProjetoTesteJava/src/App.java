import java.io.*;

class Conta{
    private int id;
    
    protected int getId () {
        return id;
    }
    
    protected int setId (int id) {
        this.id = id;
        return this.id;
    }
   
}  

class ContaCorrente extends Conta{
    
    public void exibeConta () {
        System.out.println("exibindo esta ContaCorrente");
    }
       
}

public class App {
    public static void main(String[] args) {
        Conta conta = new ContaCorrente();  
        
        System.out.println(conta.getId());
        
        conta.setId(12);
        
        System.out.println(conta.getId());
    }
    
}
    
