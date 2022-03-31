import java.io.*;

class Conta{
    private int id;
    
    protected void abrir() {
        System.out.println("abrindo conta");
    }
    
    private void someu() {
       System.out.println("este é o meu método"); 
    }
    
}  

class ContaCorrente extends Conta{
    
    public void exibeConta () {
        
    }
       
}

public class App {
    public static void main(String[] args) {
        Conta conta = new ContaCorrente();
              
        conta.abrir();
        
        for(int i = 1;i<=10;i++){
            System.out.println("O numero exibido no for e: " + i);
            i +=1;
        }
        
    }
    
}
    
