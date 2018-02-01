package lesson6;

public class MinMaxValue {
    public static void main(String[] args) {
        int ar[] = {2, 3, -1, 6, 6, 6, 7, 8, 9, 0, 1111};
        int min = ar[9];
        int max = ar[0];
        for (int i : ar) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;

        }
        System.out.println("Min int in array: " + min);
        System.out.println("Max int in array: " + max);

    }
}
