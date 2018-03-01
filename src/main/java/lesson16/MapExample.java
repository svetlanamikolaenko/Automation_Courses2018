package lesson16;

import org.testng.annotations.Test;

import java.util.*;

public class MapExample {
    @Test
    public void mapFor()   {

        Map<String, Double> map = new HashMap<>();
        map.put("StarWars1", 8.2);
        map.put("StarWars2", 3.25);

    Set<Map.Entry<String, Double>> entries = map.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            //получить ключ
            String key = entry.getKey();
            //получить значение
            Double value = entry.getValue();
            System.out.println("Movie title: " + key + " Rating: " + value );
        }

    }

//  НЕ ПРАВИЛЬНЫЙ!!! НИКОГДА НЕ ИСПОЛЬЗОВАТЬ! ТАКЖЕ С i <sexnames.size()
//  @Test
//    public void listIterator(){
//        List<String > sexNames = new ArrayList<>();
//        sexNames.add("Slava");
//        sexNames.add("Jessika");
//        Iterator
//        for (String s: sexNames){
//            if (s.contains("J")){
//                sexNames.remove(s);
//            }
//        }
//    }

    @Test
    public void listIterator(){
        List<String> sexNames = new ArrayList<>();
        sexNames.add("Slava");
        sexNames.add("Jack");
        sexNames.add("Jessika");
        sexNames.add("Kolya");
        sexNames.add("Kolya");

        System.out.println("Original: "+sexNames);
        Iterator<String> iterator = sexNames.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            if(s.contains("J")){
                iterator.remove();
            }
        }


        System.out.println("Removed: "+sexNames);
    }
}


