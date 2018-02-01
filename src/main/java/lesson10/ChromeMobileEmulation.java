package lesson10;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lolik on 29.01.2018.
 */
public class ChromeMobileEmulation {

    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        mobileEmulation.put("deviceName", "iPhone 5");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(options);
    }

    @Test
    public void testTakeScreen() throws IOException, InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(10000);
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}