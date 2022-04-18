import java.util.*;
import models.*;
public class App {
    public static void main(String[]args){
        ContaCorrente conta1 = new ContaCorrente(1234,"1234");        
        
        ContaCorrente conta2 = new ContaCorrente();        
        
        conta1.setDepositar(10);
        
        conta1.setSacar(8);
        
        conta2.setDepositar(220);
        
        conta2.setSacar(20);
        
        conta1.getSaldo();
        
        conta2.getSaldo();
        
    }
}
