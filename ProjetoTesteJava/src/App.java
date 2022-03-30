class D extends C {
    void x() { System.out.println(1); }
    void y(C b) {
        x();
    }
}
class C extends B {
    void x() { System.out.println(2); }
}
class B {
    void x() { System.out.println(3); }
    void y(B b) {
        b.x();
    }
}
public class App {
    public static void main(String[] args) {
        new D().y(new C());
    }
}