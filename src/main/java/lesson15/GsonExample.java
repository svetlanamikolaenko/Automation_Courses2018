package lesson15;

import com.google.gson.Gson;
import org.testng.annotations.Test;

public class GsonExample {
    String cardJson = " {\n" +
            "        \"id\": \"5a8aaf5b8bc73165a15f071f\",\n" +
            "        \"desc\": \"Some Card Description\",\n" +
            "        \"idBoard\": \"5a8aaf518e5ac8fff8dd5f67\",\n" +
            "        \"idList\": \"5a8aaf5838440fc96023077d\",\n" +
            "        \"name\": \"Jack\",\n" +
            "        \"url\": \"https://trello.com/c/Q48O9oWn/1-jack\"\n" +
            "    }\n";

    @Test
    public void jsonToJava(){
        Gson gson = new Gson();
        Card card = gson.fromJson(cardJson, Card.class);
        System.out.println(card);
        String json = gson.toJson(card);
        System.out.println(json);
    }

}
