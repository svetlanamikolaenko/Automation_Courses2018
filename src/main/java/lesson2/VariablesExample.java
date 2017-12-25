package lesson2;

public class VariablesExample {

        public static void main (String [] args) {
            int myNumber = 10;
            int mySecondNumber = 20;
            int result = myNumber + mySecondNumber;
            System.out.println("RESULT: "+result);

            String word = "Hello";
            String firstName = "Jake";
            String lastName = "Sparrow";
            String phrase = word+firstName+lastName;
            System.out.println("PHRASE: "+phrase);
            System.out.println();
            System.out.println("PHRASE WITH SPACES: "+ word + " " + firstName +" "+ lastName +"!");
        }
    }


