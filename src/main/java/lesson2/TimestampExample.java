package lesson2;

import java.sql.Timestamp;

public class TimestampExample {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp.getTime());
    }
}