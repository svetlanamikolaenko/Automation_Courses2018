package lesson10;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by lolik on 29.01.2018.
 */
public class SwitchToWindowExample {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
    }



    @Test
    public void switchToWindow() throws IOException, InterruptedException {
        driver.get("https://google.com");
        ((JavascriptExecutor) driver).executeScript( "window.open('')"); // Открыть новое окно
        String firstWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for(String windowName : windowHandles){
            if(!windowName.equals(firstWindow)){
                driver.switchTo().window(windowName);
            }
        }
        driver.get("https://facebook.com");
        driver.switchTo().window(firstWindow);



    }




    @Test
    public void switchToWindowTry() throws IOException, InterruptedException {
        driver.get("https://google.com");
        ((JavascriptExecutor) driver).executeScript( "window.open('')"); // Открыть новое окно
        String mainWindow = switchToNextWindow();
        driver.get("https://facebook.com");
        driver.switchTo().window(mainWindow);
        driver.get("https://facebook.com");
        Thread.sleep(10000);
    }



    public String switchToNextWindow() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfWindowsToBe(2));
        Iterator<String> iterator = driver.getWindowHandles().iterator();
        String mainWindow = iterator.next();
        driver.switchTo().window(iterator.next());
        return mainWindow;
    }



    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}