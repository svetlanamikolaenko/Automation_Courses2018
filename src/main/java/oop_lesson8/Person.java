package oop_lesson8;

public class Person {

    private String firstName;
    private String lastName;
    private int id;
    static int depId = 4;


    public Person(String firstName, String lastName,int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public  String getLastName(){
        return lastName;
    }
    public int getId(){
        return id;
    }

    protected void changeId(){
        System.out.println(changePersonId());

    }

    private int changePersonId(){
        return id++;

    }

}
