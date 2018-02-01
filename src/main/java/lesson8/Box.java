//package lesson8;
//
//public class Box {
//
//
//    public Box(double width, double height, double depth) {
//        this.width = width;
//        this.heights = height;
//        this.depth = depth;
//    }
//
//    public double depth; // глубина
//    public Box(double depth){
//        this.depth = depth;
//    }
//
//    public String name;
//    public Box(double width, double height, double depth, String name){
//        this(width, height, depth); // Вызов конструктора для заполнения полей
//        this.name = name;
//    }
//
//    Box box = new Box(10, 20, 30);
//    Box box2 = new Box(10, 10, 10);
//    Box box3 = new Box(17, 15, 4);
//
//
//    public double width;
//    public double heights;
//    public static double depth;
//
//    public String getVolume() {
//        return "Объем коробки " + (width * heights * depth);
//
//    }
//
//    public void printInfo() {
//        System.out.println("Объем коробки: " + getVolume());
//    }
//}