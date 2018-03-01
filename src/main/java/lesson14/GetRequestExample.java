package lesson14;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetRequestExample {
    OkHttpClient client = new OkHttpClient();

    public String getRequest(OkHttpClient client, String url) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Accept-Language", "en-US,en;q=0.5")
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Test
    public void getExample() throws IOException {
        String response = getRequest(client, "https://www.imdb.com/chart/top");
        System.out.println(response);
    }


    @Test
    public void userAgentTest() throws IOException {
        client = new OkHttpClient.Builder()
                .addInterceptor(new UserAgentInterceptor("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36"))
                .build();
        String response = getRequest(client, "https://www.whatismybrowser.com/detect/what-is-my-user-agent");


        Document doc = Jsoup.parse(response);
        String text = doc.select(".detected_result a").get(0).text();
        System.out.println(text);
    }



}

