import estruturasTeste.*;

class B{}
class C{}
class D extends B{}

public class App {
    static int a(D d, B b2) { return 1; }
    static int a(C c, C c2) { return 2; }
    static int a(B b, B b2) { return 3; }
    static int a(App a, App a2) { return 4; }
    public static void main(String[] args) {
        System.out.println(a(new D(), new D()));
    }
}

