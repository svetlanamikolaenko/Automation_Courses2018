package lesson12abc;

public class Dog extends Pet{
   @Override
    public void voice(){
       System.out.println("GAF GAF");
       isHungry = true;

   }
   @Override
    public  void move(){
       if (isHungry){
           System.out.println("I need food");
           return;
       }
       System.out.println("OK, I will walk a little");
   }


}
