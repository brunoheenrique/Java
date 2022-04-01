package classesPend;
import java.util.*;

interface Z {}
interface W {}
interface Y extends Z, W {}
class B {}
class C extends B implements Y {}
class D extends B implements Z, W {}
class E extends C {}

public class Teste {
    /*public static void main(String[]args){
        C c = (C) new B();
    }*/
}   