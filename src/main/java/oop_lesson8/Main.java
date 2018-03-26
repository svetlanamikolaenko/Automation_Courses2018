package oop_lesson8;

import org.eclipse.jetty.util.Utf8Appendable;
import org.eclipse.jetty.websocket.common.message.Utf8CharBuffer;

public class Main {
    public static void main (String [] args){

        Person p1 = new Person("John", "Snow", 1);
        Person p2 = new Person("Sveta", "Mikolaeko", 2);

        Developer d1 = new Developer("Linus", "Torvalds", 5);
        Developer d2 = new Developer("Ivan", "Smoth", 10);

        d1.getLastName();
        System.out.println(p1.getFirstName() + " " + p1.getLastName());
        System.out.println(d1.getFirstName() + " " + d1.getLastName());

        String mInfoTextView = "";

        int[] mice = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        for (int i = mice.length - 1; i >= 0; i--) {
            mInfoTextView = (" " + mice[i]);
            System.out.print(mInfoTextView);
        }

    }
}
