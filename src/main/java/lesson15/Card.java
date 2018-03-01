package lesson15;

public class Card {
    public String id;
    public String desc;
    public String idBoard;
    public String idList;
    public String name;
    public String url;

    @Override
    public String toString() {
        return "Card{" + "id='" + id + '\'' + ", desc='" + desc + '\'' + ", idBoard='" + idBoard + '\'' + ", idList='" + idList + '\'' + ", name='" + name + '\'' + ", url='" + url + '\'' + '}';
    }


}
