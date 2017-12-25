package homework2;

public class DigitsSum {
    public static void main(String [] args) {
        int n = 56;
        int x = (char) n/10;
        int y = (char) n%10;
        int z = x+y;
        System.out.println("Sum n = "+ z);
    }
}
