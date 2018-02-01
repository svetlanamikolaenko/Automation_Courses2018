package homework7;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class LoginKismia {
    public static WebDriver driver;


    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://kismia.com/");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("return window.stop");//остановить загрузку страницы
    }

    @Test (priority = 1)
    public void testLogin() throws InterruptedException {

        driver.findElement(By.cssSelector("#user-email")).sendKeys("svetlana.mikolaenko@gmail.com");
        driver.findElement(By.cssSelector("#user-password")).click();
        driver.findElement(By.cssSelector("#user-password")).sendKeys("qweewq");
        driver.findElement(By.cssSelector("#user-password")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        String titleActual = driver.getTitle();
        String titleExpected = "Kismia";
        System.out.println("You are on the website "+ titleActual);
        Thread.sleep(2000);
        Assert.assertEquals(titleActual, titleExpected, "Passed");
        Assert.assertEquals("Kismia", titleExpected);
        System.out.println("You've logged in");
        Thread.sleep(2000);
    }

    @Test (priority = 2)
    public void sendMessage() throws InterruptedException {
        driver.get("https://kismia.com/matches");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div.new-content > a")).click();
        WebElement message = driver.findElement(By.cssSelector(".multiple-ping__cell-wrapper)"));
        String messageText = message.getText();
        System.out.println(messageText);




    }

    @AfterTest
    public void quit(){ driver.quit();}
}

