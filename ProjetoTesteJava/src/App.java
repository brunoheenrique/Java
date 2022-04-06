abstract class B {
    void x() {
        System.out.println(y());
    }
    Object y() { return "a"; }
}
abstract class C extends B {
    abstract String y();
}
class D extends C {
    String y() { return "b"; }
}
class A {
    public static void main(String[] args) {
        D d  = (D) (C) new D();
        d.x();
    }
}

