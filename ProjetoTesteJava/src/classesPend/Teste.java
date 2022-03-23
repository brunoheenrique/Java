package classesPend;

class A {
    final String n;
    A(){
        a();
        n = "aprendendo";
    }
    void a(){
        System.out.println("testa");
    }
}

public class Teste extends A {
    void a (){
        System.out.println(n.length());
    }
    public static void main(String[] args) {
        new Teste();
    }
}