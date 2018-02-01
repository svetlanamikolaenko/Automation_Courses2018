package homework7;

import java.util.Scanner;

public class RandomGame {
    public static void main(String[] Args){

        final int min = 0; // Минимальное число для диапазона
        final int max = 100; // Максимальное число для диапазона
        final int randomValue = rnd(min, max);

        //System.out.println("Псевдослучайное целое число: " + rnd);

        Scanner player1 = new Scanner(System.in);
        System.out.println("Player1: Please enter number from 0 to 100");
        int userValue = player1.nextInt();
        while (userValue<0 | userValue>100){
            System.out.println("Incorrect value");
            userValue =player1.nextInt();
            break;
        }
        System.out.println("Player1 entered the number: "+ userValue);

        final int min1=0;
        final int max1=100;
        final int randomPlayer2 = random(min1,max1);
        System.out.println("Player2 entered the number: "+ randomPlayer2);

        System.out.println("Computer value is " + randomValue);
       if (userValue>=randomPlayer2 & userValue>=randomValue){System.out.println("P1 win");}
       if (userValue<=randomPlayer2 & userValue<=randomValue){System.out.println("P1 loose");}

    }

    /** Метод получения псевдослучайного целого числа от min до max (включая max);**/
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static int random(int min1, int max1)
    {
        max1 -= min1;
        return (int) (Math.random() * ++max1) + min1;
    }

}
