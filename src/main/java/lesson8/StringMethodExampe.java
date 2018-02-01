package lesson8;

public class StringMethodExampe {
    public  static void main(String [] args) {
        String names = "Sveta,Pasha,Timur";
        String[] stringArray = names.split(",");
        for (String name: stringArray){
            System.out.println(name);
        }
    }
}
