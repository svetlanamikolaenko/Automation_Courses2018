package OOPJavaLessons;

public class Employee {

    String firstName;
    String lastName;

    Employee(String firstName, String lastName){

        this.firstName = firstName;
        this.lastName = lastName;

    }
    public String getInfo() {
        String result = "My name is " + firstName + " " + lastName + ".";
        return result;
    }

    public void work(int hours){
        System.out.println("I am gonna work for " + hours + " hours!" );
    }

    public void  work (int hours, int mseconds){

    }

}
