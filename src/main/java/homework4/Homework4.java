package homework4;

import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {

        int a = 5;
        int b = 15;
        int c = 15;
        int d = 15;
        int e = 35;
        int max_number;
        int min_number = 0;
        int q = 0; // для решения 2 задачи добавляем счетчик
        if (a < b && a < c && a < d) {
            min_number = a;
        }
        if (b <a && b <c && b < d) {
            min_number = b;
        }
        if (c < a && c <b && c <d) {
            min_number = c;
        }
        if (d < a && d <b && d < c) {
            min_number = d;
        }

        if (a >= b && a >= c && a >= d) {
            max_number = a;
            q++;
        }
        if (b >= a && b >= c && b >= d) {
            max_number = b;
            q++;

            if (c >= a && c >= b && c >= d) {
                max_number = c;
                q++;
            }
            if (d >= a && d >= b && d >= c) {
                max_number = d;
                q++;
            }
            System.out.println("Задание 1: ");
            System.out.println("Среди 4 чисел MIN: " + min_number);
            System.out.println("Среди 4 чисел MAX: " + max_number);
            System.out.println("Задание 2: ");
            System.out.println("Среди 4 чисел MAX: " + max_number);
            System.out.println("Среди 4 чисел одинаковых: " + q + " числа");
            //Задача 3. Поиск среди 5 чисел  минимального и максимального числа
            if (e<=min_number){
                min_number = e;
            }else {
                max_number = e;
            }
            System.out.println("Задание 3: ");
            System.out.println("Среди 5 чисел MIN: " + min_number);
            System.out.println("Среди 5 чисел MAX: " + max_number);
        }

        System.out.println("Задание 4: ");
        String name1 = new String("Андрей");
        String name2 = new String ("Андрей");
        if (name1.equals(name2)){
            System.out.println("Тезки");
        } else {
            System.out.println("Они не тезки");
        }
        System.out.println("Задание 5: ");
        // Задача 5. Получить сезон
        Scanner month = new Scanner(System.in);
        System.out.println("Введите число месяца: ");
        int numb_month = month.nextInt();
        String season;
        switch (numb_month) {
            case 1:  season = "Зима";
                break;
            case 2:  season = "Зима";
                break;
            case 3:  season = "Весна";
                break;
            case 4:  season = "Весна";
                break;
            case 5:  season = "Весна";
                break;
            case 6:  season = "Лето";
                break;
            case 7:  season = "Лето";
                break;
            case 8:  season = "Лето";
                break;
            case 9:  season = "Осень";
                break;
            case 10:  season = "Осень";
                break;
            case 11:  season = "Осень";
                break;
            case 12: season = "Зима";
                break;
            default: season = "Ошибка";
                break;
        }
        System.out.println(season);

    }
}