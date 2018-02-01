package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by lolik on 29.01.2018.
 */
public class PageLoadStrategyExample {

    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.setCapability("pageLoadStrategy", "normal");
        driver = new ChromeDriver(options);
    }


    @Test
    public void testTakeScreen() throws IOException, InterruptedException {
        driver.get("https://kismia.com");
        //System.out.println(((JavascriptExecutor) driver).executeScript("return document.readyState"));
    }



    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}