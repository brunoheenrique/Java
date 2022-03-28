import classesPend.*;
public class App {
    public static void main(String[] args) {
        int[] i = {150, 151};
        i = s(i);
        System.out.println(i[1]);
    }
    static int[] s(int[] i) {
        int[] j = {i[0], i[1]};
        i[1]++;
        return j;
    }
}

