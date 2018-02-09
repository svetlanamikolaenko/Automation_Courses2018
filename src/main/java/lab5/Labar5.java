package lab5;

import java.util.Scanner;

public class Labar5 {

    public static void main(String[] args) {
        Scan s = new Scan();
    }
}

class Scan {
    private Scanner sc;
    public Scan() {
        System.out.println("Введите число:");
        sc = new Scanner(System.in);
        try {

            double x = sc.nextDouble();
            System.out.println(x);

        } catch (Exception e) {
            System.out.println("Не правильный формат ввода");
        }
    }
}