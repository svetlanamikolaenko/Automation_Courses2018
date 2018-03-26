package oop_lesson8;

public class Developer extends Person {

    public Developer(String firstName, String lastName, int id) {
        super(firstName, lastName, id);
    }

    public void develop (String task){
        System.out.println("I am doint the task "+ task + " now!");
    }

    @Override
    protected void changeId(){
        int devId = getId() + 2;


    }
}
