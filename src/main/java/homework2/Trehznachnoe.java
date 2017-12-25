package homework2;

public class Trehznachnoe {
    public static void main(String[] args) {
        int n = 383;
        int x = n /100;
        int y = n % 100;
        int z = y/10;
        int k = n%10;
        int sum = x+z+k;
        System.out.println("Cумма трехначного числа "+ n + " = " + sum);
        }
}
