package lesson15;

import okhttp3.*;

import java.io.IOException;

public class TrelloApiNew {
    public static final String KEY = "92484d360b88cb01c7ca8e37f1e96019";
    public static final String TOKEN = "e205a262c1c4334fc3ba6fe9a122b9097c5b5215f984266f6e5f0184e53beb1e";
    OkHttpClient client = new OkHttpClient();

    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    public String getBoardList(String boardId ) throws IOException {
        String url = "https://api.trello.com/1/boards/"+boardId+"/lists?l&key="+KEY+"&token="+TOKEN;
        String response = get(url);
        return response;

    }
    public String getBoardLabel(String labelId ) throws IOException {
        String url = "https://api.trello.com/1/boards/"+labelId+"/labels?cards=all&key="+KEY+"&token="+TOKEN;
        String response = get(url);
        return response;

    }
}