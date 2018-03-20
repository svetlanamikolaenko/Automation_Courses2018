package imap;

import org.apache.commons.lang3.RandomStringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class MessageContent {

    private static final String UNAVAILABLE = "unavailable";
    private String content;

	public MessageContent(String content) {
		this.content = content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getLinkUrls() {
		List<String> links = new ArrayList<>();
		Document doc = Jsoup.parse(content, "UTF-8");
		for (Element link : doc.select("a[href]")) {
			links.add(link.absUrl("href"));
		}
		return links;
	}

	public List<String> getImgUrls() {
		List<String> srcs = new ArrayList<>();
		Document doc = Jsoup.parse(content, "UTF-8");
		for (Element src : doc.select("img[src]"))
			srcs.add(src.absUrl("src"));
		return srcs;
	}

	public File save(String folder, String name) {
		new File(folder).mkdirs();
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(folder + "/" + name + ".html", "UTF-8");
			pw.write("\uFEFF");
			pw.write(content);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("Info:" + "Messages content saved: " + folder + "/"
				+ name + ".html");
		return new File(folder + "/" + name + ".html");
	}

	public File save(String folder) {
		new File(folder).mkdirs();
		String name = RandomStringUtils.randomAlphanumeric(10).toLowerCase()
				+ "_" + System.currentTimeMillis();
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(folder + "/" + name + ".html", "UTF-8");
			pw.write("\uFEFF");
			pw.write(content);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new File(folder + "/" + name + ".html");
	}

    /*public String getMessageContentLang() {
        if (content.contains(UNAVAILABLE))
            return UNAVAILABLE;
        try {
            String contentText = Jsoup.parse(this.content).text();
            Detector detector = DetectorFactory.create();
			detector.append(contentText);
			return detector.detect();
        } catch (LangDetectException e) {
            e.printStackTrace();
        }
        return UNAVAILABLE;
    }*/
}