package homework8;

public class Polindrom {
    public static void main(String[] args) {
        String str = "Искать такси";
        String newStr = str.replace(" ", "").toLowerCase();
        char[] chArray = newStr.toCharArray();
        int a = newStr.length();
        int b = 0;
        for (int i = 0; i < newStr.length(); i++) {
            for (int j = newStr.length() - i - 1; j >= 0; j--) {
                if (chArray[j] == chArray[i]) {
                    b++;
                    break;
                }
            }
        }
        if (a == b){ System.out.println("Word \"" + str + "\" is a POLINDROM");}
        else
            {System.out.println("Word \"" + str + "\" is NOT a POLINDROM");}


    }
}