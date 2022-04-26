import src.*;

public class Main {
    public static void main(String[] args) {
        Fisica pessoa1 = new Fisica("Bruno",26,"44662308895");
        
        pessoa1.getNome();
        pessoa1.getIdade();
        pessoa1.getCPF();
        
        pessoa1.fazerAniversario();
        pessoa1.getIdade();
        
    }        
}