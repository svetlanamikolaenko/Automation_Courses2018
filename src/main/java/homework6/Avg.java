package homework6;

public class Avg {
    public static void main(String [] args){
        int arrFifth [] = {5, 6, 8, 10, 2 , 3};
        int sum = 0;
        float avg;
        for (int x: arrFifth)  sum = sum + x;

        System.out.println("Сумма всех чисел в массиве: "+ sum);
        System.out.println("Количество всех єлементов в массиве: " + arrFifth.length);
        avg = (float) sum/arrFifth.length;
        System.out.println("Среднее арифметическое в массиве: " + avg);

    }
}
