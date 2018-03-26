package OOPJavaLessons;

public class Main {

    public static void main (String [] args ) {

        Employee emp1 = new Employee("John", "Snow");
        String result = emp1.getInfo();
        System.out.println(result);
        emp1.work(8);


    }

}
