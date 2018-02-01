package lesson8;

public class StringExample {
    public static void main(String [] args){
        String myString = "JACK";
        myString.concat(" Sparrow");
        System.out.println(myString);

//метод concat возвращает новую строку - ОН НЕ ИЗМЕНЯЕТ ОБЪЕКТ
        myString = myString.concat(" SPARROW"); // myString = "JACK" + " SPARROW"
        System.out.println(myString); // JACK SPARROW

    }
}
