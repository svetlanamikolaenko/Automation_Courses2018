package lab2;

public class Labar2a {
    public static void main (String [] args){
        int x =2;
        int y = 3;
        int a = 1000;
        float b = 0.0001f;
        System.out.println("Значение при типе данных float ="+  (Math.pow((a-b), y) -  Math.pow(a,y))/
                (Math.pow(b,y) - (3 * a * Math.pow(b, x)) - (3 * Math.pow(a, 2) * b)));

        double i = (double) b;

        System.out.println("Значение при типе данных double = " + ((Math.pow((a-i), y) -  Math.pow(a,y))/
                (Math.pow(i,y) - (3 * a * Math.pow(i, x)) - (3 * Math.pow(a, 2) * i))));

    }
}
