package lesson8;

public class UserMain {

    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();

        user1.name = "Masha";
        user1.age = 25;

        user2.name = "Jack";
        user2.age = 70;
        user2.city = "New York";

        User.proffesion = "Teacher";//статическая переменная относится к классу , если написать final  - то она станет константой

        System.out.println(user1.name + " : "+ user1.age + " : " + user1.proffesion);
        System.out.println(user2.name + " : " + user2.age + " : " + user2.city+ " : " + user2.proffesion);

    }
}
