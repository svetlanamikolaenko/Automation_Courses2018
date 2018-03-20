package lesson22;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestChromeBuilder {
    @Test
    public void azazaza() throws InterruptedException {
        WebDriver driver = new ChromeDriverBuilder()
                .setMobileEmulation("iPhone 7")
                .setPageLoadStrategy("normal")
                .build();
        driver.get("https://google.com");
        Thread.sleep(5000);
        driver.quit();
    }
}
