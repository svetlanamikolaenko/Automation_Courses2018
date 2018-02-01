package lesson10;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by lolik on 29.01.2018.
 */
public class TakesScreenshotExample {

    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
    }


    @Test
    public void testTakeScreen() throws IOException {
        driver.get("https://google.com");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("/home/svitlanamykolaienko/Automation/Highway2018/screenshots/1_fail.png"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}