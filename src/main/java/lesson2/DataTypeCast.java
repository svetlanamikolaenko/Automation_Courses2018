package lesson2;

public class DataTypeCast {
    public static void main(String[] args) {
        int i = 6052;
        long lo = i;
        short s = (short) lo;
        System.out.println(s);

        char ch = 'J';
        int intCh = (int) ch;
        System.out.println("J corresponds with " + intCh);


        double b = 2.6;
        int c = (int)(0.5+b);// можно применять к целым выражениям
        System.out.println(c);
        System.out.println((int)9.69);
        //System.out.println((int));

    }
}
