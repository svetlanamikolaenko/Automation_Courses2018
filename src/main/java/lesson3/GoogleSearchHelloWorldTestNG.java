package lesson3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchHelloWorldTestNG {
    public WebDriver driver;

    @BeforeTest
    public void setUp(){driver = new ChromeDriver();}

    @Test
    public void myAweSomeTest() {
        driver.get("https://google.com");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
