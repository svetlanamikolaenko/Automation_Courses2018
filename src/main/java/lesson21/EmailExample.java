package lesson21;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EmailExample {

    @Test
    public void aqaqa() throws EmailException {
        // Create the email message

        WebDriver driver = new ChromeDriver();
        driver.get("https://stackoverflow.com/questions/7263824/get-html-source-of-webelement-in-selenium-webdriver-using-python");
        String pageSource =  driver.getPageSource();

        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.googlemail.com"); // Set SMTP hostname
        email.setSmtpPort(465); // Set port
        email.setAuthenticator(new DefaultAuthenticator("svitlana.mykolaienko@gen.tech", "Sveta131264")); // Set email/password
        email.setSSLOnConnect(true); // SSL true
        email.setFrom("trello@onthe.io"); // set FROM
        email.setSubject("TestMail"); // set Subject
        email.setHtmlMsg(pageSource); // Set message
        email.addTo("trello@onthe.io");
        email.send(); // Send Email
        driver.quit();
    }
}
