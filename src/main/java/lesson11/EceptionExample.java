package lesson11;

public class EceptionExample {
    public static void main(String [] args){
        int a = 4;
        try {
            System.out.println(a/0);
        } catch (ArithmeticException e){
            System.out.println("Произошла недопустимая ошибка");
            System.out.println(e.getMessage());
        }

    }
}
