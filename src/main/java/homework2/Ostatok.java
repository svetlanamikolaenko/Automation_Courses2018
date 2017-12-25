package homework2;

public class Ostatok {
    public static void main(String [] args){
        float n = 8.7f;
        float x = n*10;
        int y = (char) x%10;
        if (y<=5){
            System.out.println((int)n);
        }
        else {
            System.out.println((int) n+1);
        }
    }
}
