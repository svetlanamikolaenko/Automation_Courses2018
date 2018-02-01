package homework6;

public class InsertionSort {
        public static void main (String [] args){

        int [] array = {5,-6,8,-10,4,55,68,1,13,8,15} ;
        for (int index =1; index<array.length; index++){
            int value = array[index];
            int j = index-1;//сравнить значение которое левее от него
            while (j>=0){//пока j больше или равно 0 перемещаться влево
                if(value < array[j]){
                    array[j+1] = array[j];//перенести число вправо на index+1
                    array[j] = value;//перенести число вправо
                    j= j-1;
                }

                else {
                    break;
                }
            }

        }
           for (int n = 0; n<array.length; n++) {
               System.out.print(array[n] + " ");
           }


    }
}
