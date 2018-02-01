package lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.function.Function;

/**
 * Created by lolik on 29.01.2018.
 */
public class ExplicitWaitsExample {

    public WebDriver driver;



    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
    }


    @Test
    public void waitKismia(){
        driver.get("https://kismia.com");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("kismia"));
        wait.until(urlContainsKis());
        wait.until(urlContainsKismia);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    public ExpectedCondition<Boolean> urlContainsKis(){
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return webDriver.getCurrentUrl().contains("kis");
            }
        };
    }


    public ExpectedCondition<Boolean> urlContainsKismia = webDriver -> webDriver.getCurrentUrl().contains("kismia.com");


}