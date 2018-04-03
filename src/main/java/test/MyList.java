package test;

public class MyList {

  private Integer[] data = new Integer[10];
  private int realCount = 0;

    public MyList() {
    }


    public void addNumber(int number) {
       if (data.length == realCount){
           Integer[] dataNew = new Integer[data.length + 1];
           for (int i = 0; i < data.length; i++){
               dataNew[i] = data[i];
           }
           dataNew[dataNew.length - 1] = number;
           data = dataNew;
       } else {
           data[realCount] = number;
       }
       realCount++;

    }

    public int getSize() {
        return realCount;
    }

    public void removeNumber(int position) {
        if (position > realCount) {
            System.out.println("no number");
        } else {
            for (int i = position; i < realCount- 1; i++) {
                data[i] = data[i+1];
            }
            data[realCount - 1] = null;
            realCount--;
        }
    }

    public Integer getValue(int index) {
        for (int i = 0; i< data.length ; i++){
            index = i;
        }
        return data[index];

    }

    public void printList() {
        for (int i = 0; i < realCount; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public void addAll(MyList anotherList) {

    }



}
