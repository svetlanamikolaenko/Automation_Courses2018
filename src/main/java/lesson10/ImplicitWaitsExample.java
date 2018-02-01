package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lolik on 29.01.2018.
 */
public class ImplicitWaitsExample {

    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        // driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void azaza() throws InterruptedException {
        driver.get("https://google.com");
        driver.findElement(By.cssSelector("#NoElementHere")).click();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}