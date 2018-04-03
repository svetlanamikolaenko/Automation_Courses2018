package test;

import java.util.ArrayList;

public class MainClass {

    int a = 5;



    public static void main(String[] args) {
//        String param1 = args[0];
//        String param2 = args[1];

        Cat vasya = Cat.giveMeNewCat();
        Cat petya = Cat.giveMeNewCat();
        ArrayList<Integer> list = new ArrayList();

        vasya.setName("andrew");
        System.out.println(vasya);
        System.out.println(petya);

        vasya.setAge(5);

        int[] myArray = {2 , 3, 12 , 15, 18};
        int[] myArray2 = new int[6];
        int[] myArray3 = new int[0];
        myArray2[0] = 10;
        myArray2[1] = 10;
        myArray2[2] = 10;
        myArray2[3] = 10;
        myArray2[4] = 10;
        myArray2[5] = 10;


        for (int i = 0 ; i < myArray2.length; i++) {
            myArray2[i] = 10;
        }

        MyList listOne = new MyList();
        listOne.addNumber(42);
        listOne.addNumber(15);
        listOne.addNumber(16);
        listOne.addNumber(6);
        listOne.addNumber(7);
        listOne.addNumber(8);
        listOne.addNumber(9);
        listOne.addNumber(10);
        listOne.addNumber(11);
        listOne.addNumber(12);
        listOne.addNumber(13);
        listOne.addNumber(14);
        listOne.addNumber(15);
        listOne.removeNumber(0);
        listOne.removeNumber(0);
        listOne.removeNumber(0);
        listOne.getValue(5);
        int b = listOne.getValue(5);
        System.out.println(b);


        MyList listTwo = new MyList();
        listTwo.addNumber(42);
        listTwo.addNumber(43);
        listTwo.addNumber(44);

        listOne.removeNumber(5);

        listOne.addAll(listTwo);

        MyList listThree = new MyList();
        for (int i = 0; i < 1000; i = i + 2){
            listThree.addNumber(i);

        }
        listOne.printList();
    }
}
