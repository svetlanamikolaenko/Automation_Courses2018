package homework6;

public class Array4 {
    public static void main (String [] args){
    int arrThird []= {4, -5, 0, 6, 8};
    int min = arrThird[0];
    int max = arrThird[0];
    int temp = 0;
    int max_index = arrThird[0];
    int min_index = arrThird[0];

    for (int i=0; i<arrThird.length; i++){
        if (arrThird[i]<=min) {
            min = arrThird[i];
            min_index=i;
        }
        if (arrThird[i]>=max) {
            max = arrThird[i];
            max_index=i;
        }
    }
        System.out.println("Array before moving:");
    for (int arrayElement: arrThird){
        System.out.print(arrayElement + " ");
    }

    for (int j=0; j<arrThird.length;j++){
        temp = arrThird[max_index];
        arrThird[max_index] = arrThird[min_index];
        arrThird[min_index] = temp;
    }

    System.out.println();
    System.out.println("Array after moving:");
    for (int arrayElement: arrThird){
        System.out.print(arrayElement + " ");
    }
    }

}
