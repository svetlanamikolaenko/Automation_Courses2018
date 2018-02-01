package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class JavascriptExecutorExample {

    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        // driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }


    @Test
    public void jsScrollExample() throws InterruptedException {
        driver.get("http://www.imdb.com/chart/top");
        WebElement element = driver.findElement(By.cssSelector("a[href='/conditions']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(10000);
    }

    @Test
    public void jsOpenNewTabExample() throws InterruptedException {
        driver.get("https://google.com");
        ((JavascriptExecutor) driver).executeScript( "window.open('')");
        Thread.sleep(10000);
    }


    @Test
    public void jsHighlightElement() throws InterruptedException {
        driver.get("https://google.com");
        WebElement element = driver.findElement(By.cssSelector("#main [alt='Google']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
        Thread.sleep(10000);
    }




    @Test
    public void jsAsyncExample() throws InterruptedException {
        driver.get("https://google.com");
        ((JavascriptExecutor)driver).executeAsyncScript("setTimeout(function(){ alert(\"Hello\"); }, 3000);");
        driver.switchTo().alert().accept();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }





}
