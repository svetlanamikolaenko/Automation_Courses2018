package lesson8;

public class StringArray {

    public static void main (String[] args){
        String stringToDisplay = "";
        char[] charArrayToString = {'a','b','c','d'};
        for (int i=0; i<charArrayToString.length; i++){
            stringToDisplay += charArrayToString[i];
        }
        System.out.println(stringToDisplay);
    }

}
