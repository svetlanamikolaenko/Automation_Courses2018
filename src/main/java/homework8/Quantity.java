package homework8;

public class Quantity {
    public static void main(String [] args){

        String str = "aasss,assdfaasdqweaaa,asdaaaas,adsasdasd,aaa,asdghnzzzzzza,zzzzxxxaaaa,zxvvxvxcvxcv,xcvxv.fsdfsdfeweqwejhsdf sf sdfs  a a  sdfsdf sdf";
        System.out.println("СТРОКА: " + str);
        System.out.print("РЕЗУЛЬТАТ: Индекс \"a\" в строке: [");
        char[] chArray = str.toCharArray();
        int len = 0;
        char symb = 'a';
        String indexes = "";
        System.out.print("");

        for(int i=0; i<chArray.length; i++){
            if (chArray[i] == 'a'){
                len++;
            }
            if (symb == chArray[i]){

                System.out.print( i + ",");
            }


        }
        System.out.println( "];");
        System.out.println("Количество символов \"a\" в строке - " +  len + ";");



    }
}
