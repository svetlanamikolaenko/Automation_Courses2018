package lesson12abc;

public enum WeekDay {

    MONDAY(2), TUESDAY(3), WENSDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7), SUNDAY(1);
    int dayInt;
    WeekDay (int dayInt){
        this.dayInt = dayInt;
    }
    public int getDayint(){
        return dayInt;
    }
}
