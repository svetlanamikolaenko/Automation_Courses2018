package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by lolik on 29.01.2018.
 */
public class HoverElementExample {
    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
    }


    @Test
    public void hoverIT() throws InterruptedException {
        driver.get("http://www.imdb.com/");
        WebElement elem = driver.findElement(By.cssSelector("#consumer_main_nav #navTitleMenu"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).perform();
        Thread.sleep(8000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}