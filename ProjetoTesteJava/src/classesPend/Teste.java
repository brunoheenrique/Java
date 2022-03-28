package classesPend;

class B { B(Teste a) {new C(); } B() { new C(this);} }
class C { C(B b) {new B(new Teste());} C() {new B();} }
class Teste {
    public static void main(String[] args) {
        new C(new B(new Teste()));
    }
}