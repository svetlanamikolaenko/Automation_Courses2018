package test;

public class Cat {
    private int age = 100;
    private String name = "petya";
    private static Cat c;

    private Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private Cat() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Cat giveMeNewCat() {

        if (c == null) {
            c = new Cat();
            return c;
        } else {
            return c;
        }


    }

    @Override
    public String toString() {
        return "Cat{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}
