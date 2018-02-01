package lesson9;

public class Cat {

    public static void main (String [] args){
        Cat kitty = new Cat();
        kitty.meow();
        kitty.meow(3);
        kitty.meow(3, 2);
        kitty.meow(4500.25);

    }

    public void meow() {
        // параметры отсутствуют
    }

    public void meow(int count) {
        // используется один параметр типа int
    }

    public void meow(int count, int pause) {
        // используются два параметра типа int
    }

    public double meow(double time) {
        // используется один параметр типа double
        return time;
    }


}

