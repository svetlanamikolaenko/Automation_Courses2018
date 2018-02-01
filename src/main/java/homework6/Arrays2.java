package homework6;

public class Arrays2 {
    public static void main (String[] args){

        int arrSecond [] = {15,-10,-8,13,-25,-100,205,30,-10,-100,50,205,-100,10};
        int min = arrSecond[0];
        int max = arrSecond[0];
        for (int arrElement: arrSecond){
            if (arrElement<min){
                min=arrElement;
            }
            if (arrElement>max){
                max = arrElement;
            }
        }

        System.out.println("Минимальное число: " +min );
        System.out.println("Максимальное число: " + max);


    }
}
