package lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCheck {
    public static void main(String [] args) throws InterruptedException {
       System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep( 5000);
        driver.quit();
  }
}
