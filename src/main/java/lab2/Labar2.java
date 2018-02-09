package lab2;
//1.   Вычислить значение выражения при различных вещественных типах данных (float и double).
// Вычисления следует выполнять с использованием промежуточных переменных и без использования промежуточных переменных.
// Сравнить и объяснить полученные результаты.
public class Labar2 {
    public static void main (String [] args){
        int x =2;
        int y = 3;
        int a = 1000;
        float b = 0.0001f;
        float c = (float) (Math.pow((a-b), y) -  Math.pow(a,y));
        float d = (float) (Math.pow(b,y) - (3 * a * Math.pow(b, x)) - (3 * Math.pow(a, 2) * b));
        float f = c/d;
        System.out.println("Значение при типе данных float = "+ f);

        double i = (double) b;
        double k = (Math.pow((a-i), y) -  Math.pow(a,y));
        double l = (Math.pow(i,y) - (3 * a * Math.pow(i, x)) - (3 * Math.pow(a, 2) * i));
        double m = k/l;

        System.out.println("Значение при типе данных double = " + m);

   }
}
